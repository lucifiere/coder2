/*
 Navicat MySQL Data Transfer

 Source Server         : LARK-COUPON
 Source Server Type    : MySQL
 Source Server Version : 50629
 Source Host           : tddl.daily.alibaba.net:3306
 Source Schema         : LARK_COUPON_APP

 Target Server Type    : MySQL
 Target Server Version : 50629
 File Encoding         : 65001

 Date: 17/08/2019 17:02:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for coupon_template_rule
-- ----------------------------
DROP TABLE IF EXISTS `coupon_template_rule`;
CREATE TABLE `coupon_template_rule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '规则编码',
  `coupon_limit` int(11) NOT NULL COMMENT '生成时面值及有效期是否可变（1，可变，2.不可变）',
  `product_type` int(11) NOT NULL COMMENT '商品类型(1.卖品。2.电影票)',
  `channel_type` int(11) DEFAULT NULL COMMENT '渠道类型(1.自有渠道，2第三方渠道)',
  `channel_codes` varchar(5000) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '渠道编码',
  `is_below_limit` int(11) NOT NULL COMMENT '是否低于最低价(1.低于2.不低于)',
  `is_charge_fee` int(11) DEFAULT NULL COMMENT '是否收手续费',
  `is_original_price` int(11) NOT NULL COMMENT '是否原价售卖(1代表原价，2代表折后价，3代表基础售价，4代表最低票价)',
  `limit_value` bigint(20) DEFAULT NULL COMMENT '金额限制',
  `rule_desc` varchar(1000) DEFAULT NULL COMMENT '规则描述',
  `extension` varchar(2000) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '扩展字段',
  `state` int(11) NOT NULL COMMENT '状态(1.有效，2.无效)',
  `cinema_link_ids` varchar(3000) NOT NULL COMMENT '影院内码ids',
  `special_schedule` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '适用的特殊场次(明星见面会,首映式)',
  `compensate_price` char(1) DEFAULT 'Y' COMMENT '是否补差(Y:是，N：否)',
  `compensate_type` int(4) DEFAULT '1' COMMENT '补差类型(1.按原票价补差，2.按最低票价补差)',
  `coupon_effective_type` int(4) DEFAULT NULL COMMENT '券码有效期类型（1.领取日期至固定结束日期，2.固定生效-结束日期，3.券激活后xx日有效）',
  `coupon_start_date` datetime DEFAULT NULL COMMENT '券码开始时间',
  `coupon_end_date` datetime DEFAULT NULL COMMENT '券码结束时间',
  `coupon_birthday_effective_type` int(4) DEFAULT NULL COMMENT '券码生日使用限制类型（1.不限制，2.生日当天，3.生日当月）',
  `reprice_coupon_price` bigint(20) DEFAULT NULL COMMENT '重新定价券新定价（只指针对重新定价券，其他券类型无意义）',
  `coupon_type_code` bigint(20) DEFAULT NULL COMMENT '券类型编码',
  `exchange_policy` bigint(4) DEFAULT '1' COMMENT '券兑换策略(1.一对一2.多对一)',
  `compensate_rule` int(11) DEFAULT '1' COMMENT '补差规则',
  `service_fee_free` int(11) DEFAULT NULL COMMENT '是否免收服务费（1：免收，2：收取）',
  `agent_fee_free` int(11) DEFAULT '2' COMMENT '是否免收网络代售费（1：免收，2：收取）',
  `delay_effective_day` smallint(6) DEFAULT NULL COMMENT '优惠券模板设置券延期生效的天数，只有coupon_effective_type为3的时候才可以设置',
  `item_discount_rate` smallint(6) DEFAULT NULL COMMENT '卖品折扣率',
  `ticket_discount_rate` smallint(6) DEFAULT NULL COMMENT '影票折扣率',
  `cal_type_after_discount` smallint(6) DEFAULT NULL COMMENT '折后计算方式（保留两位小数：1 ； 四舍五入取整：2）',
  PRIMARY KEY (`id`),
  KEY `idx_coupontypecode` (`coupon_type_code`)
) ENGINE=InnoDB AUTO_INCREMENT=20997 DEFAULT CHARSET=utf8 COMMENT='券模板规则表';

SET FOREIGN_KEY_CHECKS = 1;
