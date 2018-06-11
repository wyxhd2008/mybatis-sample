/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ResultBody
 * Author:   ywang7
 * Date:     2018/6/6 13:49
 * Description: return object
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rick.db.mybatis.Utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 〈一句话功能简述〉<br> 
 * 〈return object〉
 *
 * @author ywang7
 * @create 2018/6/6
 * @since 1.0.0
 */
@ApiModel
public class ResultBody {

    @ApiModelProperty(value = "返回结果")
    private transient Object result;

    public ResultBody(Object result) {
        this.result = result;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

}

