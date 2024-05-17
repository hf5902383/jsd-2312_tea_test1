package fanghou.email.admin.content.pojo.po;

import lombok.Data;

import java.io.Serializable;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


/**
 * 数据持久层对象
 * 对象里的属性和数据库表的字段一一对应
 * PO是“Persistent Object”的缩写，意为“持久化对象”。
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
//不加注解TableName 基于这个泛型CategoryPO --> category_p_o
@TableName("content_category")
public class CategoryPO implements Serializable {

    /**
     * id
     * TableId 指定主键的生成方式 auto 数据库自增
     */
    @TableId(type = IdType.AUTO)
    Long id;

    /**
     * 类别名称
     */
    String name;

    /**
     * 关键字
     * 类别名称是 手机
     * keywords 苹果,小米,meta
     */
    String keywords;

    /**
     * 排序字段
     */
    Integer sort;

    /**
     * 是否启用 1 启用 0 禁用
     */
    Integer enable;

    /**
     *  我数据库表有20个分类,
     *  18个分类是启用的2个是禁用
     *  8个是在首页展示的
     * 是否在首页导航栏展示 1 展示 0 不展示
     */
    Integer isDisplay;
}