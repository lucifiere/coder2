package com.lucifiere.coder2.model

import lombok.Getter
import lombok.Setter

/**
 * 业务数据
 *
 * @author XD.Wang
 */
@Getter
@Setter
class BizDataContent {

    private String entity

    private List<Field> fields

}
