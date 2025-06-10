package com.ohgiraffers.datajpa.menu.service;

import com.ohgiraffers.datajpa.menu.dto.CategoryDTO;
import com.ohgiraffers.datajpa.menu.dto.MenuDTO;
import com.ohgiraffers.datajpa.menu.entity.Category;
import com.ohgiraffers.datajpa.menu.entity.Menu;
import com.ohgiraffers.datajpa.menu.respository.CategoryRepository;
import com.ohgiraffers.datajpa.menu.respository.MenuRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    /* ===================== 1. 단건 조회 ===================== */
    public MenuDTO findMenuByMenuCode(int menuCode) {
        Menu menu = menuRepository.findById(menuCode)
                .orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(menu, MenuDTO.class);
    }

    /* ===================== 2. 전체 조회 (정렬 포함) ===================== */
    public List<MenuDTO> findMenuList() {
        List<Menu> menuList = menuRepository.findAll(Sort.by("menuCode").descending());
        return menuList.stream()
                .map(menu -> modelMapper.map(menu, MenuDTO.class))
                .toList();
    }

    /* ===================== 3. 페이징 조회 ===================== */
    public Page<MenuDTO> findMenuList(Pageable pageable) {
        pageable = PageRequest.of(
                pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("menuCode").descending()
        );

        Page<Menu> menuPage = menuRepository.findAll(pageable);
        return menuPage.map(menu -> modelMapper.map(menu, MenuDTO.class));
    }

    /* ===================== 4. 조건 검색: 가격 초과 ===================== */
    public List<MenuDTO> findByMenuPrice(Integer menuPrice) {
        List<Menu> menuList = menuRepository.findByMenuPriceGreaterThan(
                menuPrice, Sort.by("menuPrice").descending());

        return menuList.stream()
                .map(menu -> modelMapper.map(menu, MenuDTO.class))
                .toList();
    }

    /* ===================== 5. 카테고리 전체 조회 ===================== */
    public List<CategoryDTO> findAllCategory() {
        List<Category> categoryList = categoryRepository.findAllCategory();
        return categoryList.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .toList();
    }

    /* ===================== 6. 메뉴 등록 ===================== */
    @Transactional
    public void registMenu(MenuDTO menuDTO) {
        menuRepository.save(modelMapper.map(menuDTO, Menu.class));
    }
}
