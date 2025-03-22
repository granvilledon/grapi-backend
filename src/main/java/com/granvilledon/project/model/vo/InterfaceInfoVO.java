package com.granvilledon.project.model.vo;

import com.granvilledon.grapicommon.model.entity.InterfaceInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 接口信息封装视图
 *
 * @author <a href="https://github.com/ligranvilledon">granvilledon</a>
 * @from <a href="https://granvilledon..site">granvilledon</a>
 * @TableName product
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class InterfaceInfoVO extends InterfaceInfo {

    /**
     * 调用次数
     */
    private Integer totalNum;

    private static final long serialVersionUID = 1L;
}