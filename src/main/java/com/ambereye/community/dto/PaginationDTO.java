package com.ambereye.community.dto;

import lombok.Data;
import model.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/9/16
 */
@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private List<Integer> pages = new ArrayList<>();

    public void setPagenation(Integer totalCount, Integer page, Integer size) {
        Integer totalPage = totalCount% size==0 ? totalCount / size : totalCount / size + 1;

        pages.add(page);
        //循环页数
        for (int i = 1; i <=3; i++) {
            if (page - i > 0) {
                pages.add(0,page-i);
            }

            if (page + i <= totalPage) {
                pages.add(page+i);
            }

        }

        //是否展示上一页
        if (page == 1) {
            showPrevious = false;
            //showNext = true;
        } else {
            showPrevious = true;
            //showNext = true;
        }

        //是否展示下一页
        if (page.equals(totalPage)) {
            //showPrevious = true;
            showNext = false;
        } else {
            //showPrevious = true;
            showNext = true;
        }

        //是否展示第一页
        if (pages.contains(1)) {
            showFirstPage = true;
        } else {
            showFirstPage = false;
        }

        //是否展示最后第一页
        if (pages.contains(totalPage)) {
            showEndPage = false;
        } else {
            showEndPage = true;
        }

    }
}
