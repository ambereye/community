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

    private Integer totalPage;
    public void setPagenation(Integer totalCount, Integer page, Integer size) {

        this.totalPage = totalCount% size==0 ? totalCount / size : totalCount / size + 1;

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

        //手动输入页数判断
        if(page<1){
            page = 1;
        }
        if(page>totalPage){
            page = totalPage;
        }
        this.page = page;

        //是否展示上一页
        if (page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }

        //是否展示下一页
        if (page.equals(totalPage)) {
            showNext = false;
        } else {
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