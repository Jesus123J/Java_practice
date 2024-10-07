package com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response;


import com.idevexpert.schoolnotes_fts3096_desktop.data.dto.AccountByPersonListDto;
import java.util.List;
import lombok.Data;
@Data
public class CoordinatorAccountsByPersonListResponse {
    private Integer code;
    private String message;
    private List<AccountByPersonListDto> accountsList;

}
