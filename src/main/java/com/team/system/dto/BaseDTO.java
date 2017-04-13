/*
 * #{copyright}#
 */
package com.team.system.dto;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.lang3.builder.StandardToStringStyle;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.time.DateFormatUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.team.mybatis.annotation.Condition;
import com.team.mybatis.core.BaseConstants;
import com.team.mybatis.util.TimeZoneUtil;

/**
 * 带有标准字段的 DTO 基类.
 *
 * @author shengyang.zhou@hand-china.com
 */
public class BaseDTO implements Serializable, BaseConstants {

    private static final long serialVersionUID = 5489206440998365876L;

    /**
     * 数据标识字段.
     */
    @JsonInclude(Include.NON_NULL)
    @Transient
    private String __id;

    /**
     * 数据状态字段. add,update,delete
     */
    @JsonInclude(Include.NON_NULL)
    @Transient
    @XmlTransient
    private String __status;

    /**
     * 存放所有多语言字段的描述信息.
     * <p>
     * data example:
     * 
     * <pre>
     * __tls:{
     *      roleName : {
     *          zh_CN : '管理员',
     *          en_GB : 'Admin'
     *      },
     *      description : {
     *          zh_CN : '管理员',
     *          en_GB : 'administrator'
     *      }
     *   }
     * </pre>
     */
    @Transient
    private Map<String, Map<String, String>> __tls = Collections.emptyMap();

    /**
     * 排序字段.
     */
    @JsonInclude(Include.NON_NULL)
    @Transient
    private String sortname;

    /**
     * 排序方式.
     */
    @JsonInclude(Include.NON_NULL)
    @Transient
    private String sortorder;

    /**
     * 防篡改校验字段(非数据库字段).
     */
    @JsonInclude(Include.NON_NULL)
    @Transient
    private String _token;

    /**
     * 对Record最后一次操作的系统内部请求id.
     */
    @JsonIgnore
    @Column
    @Condition(exclude = true)
    private Long requestId = -1L;

    /**
     * 对Record最后一次操作的系统内部程序id.
     */
    @JsonIgnore
    @Column
    @Condition(exclude = true)
    private Long programId = -1L;

    /**
     * Record的版本号，每发生update则自增.
     * <p>
     * 用于实现乐观锁,无法替代数据库锁.
     * <p>
     * 不能通过 update xx set object_version_number = 3 where xxx 来更新.<br>
     * 只能是自动的 update xx set a=1, object_version_number = object_version_number +
     * 1 where xxx
     */
    @Column(updatable = false)
    @Condition(exclude = true)
    private Long objectVersionNumber;

    //// 下面是标准 WHO 字段////

    @JsonIgnore
    @Column(updatable = false)
    @Condition(exclude = true)
    private Long createdBy;

    @JsonIgnore
    @Column(updatable = false)
    @Condition(exclude = true)
    private Date creationDate;

    @JsonIgnore
    @Column
    @Condition(exclude = true)
    private Long lastUpdatedBy;

    @JsonIgnore
    @Column
    @Condition(exclude = true)
    private Date lastUpdateDate;


    //// 下面是扩展属性字段////

    /**
     * 扩展属性分类.备用字段
     */
    @JsonInclude(Include.NON_NULL)
    @Column
    private String attributeCategory;

    @JsonInclude(Include.NON_NULL)
    @Column
    private String attribute1;

    @JsonInclude(Include.NON_NULL)
    @Column
    private String attribute2;

    @JsonInclude(Include.NON_NULL)
    @Column
    private String attribute3;

    @JsonInclude(Include.NON_NULL)
    @Column
    private String attribute4;

    @JsonInclude(Include.NON_NULL)
    @Column
    private String attribute5;

    public String get__id() {
        return __id;
    }

    public void set__id(String __id) {
        this.__id = __id;
    }

    public String get__status() {
        return __status;
    }

    public void set__status(String __status) {
        this.__status = __status;
    }

    @JsonIgnore
    @XmlTransient
    public Map<String, Map<String, String>> get__tls() {
        return __tls;
    }

    @JsonProperty
    public void set__tls(Map<String, Map<String, String>> __tls) {
        if (__tls != null) {
            this.__tls = __tls;
        }
    }

    public String getSortname() {
        return sortname;
    }

    public void setSortname(String sortname) {
        this.sortname = sortname;
    }

    public String getSortorder() {
        return sortorder;
    }

    public void setSortorder(String sortorder) {
        this.sortorder = sortorder;
    }

    public String get_token() {
        return _token;
    }

    public void set_token(String _token) {
        this._token = _token;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public Long getObjectVersionNumber() {
        return objectVersionNumber;
    }

    public void setObjectVersionNumber(Long objectVersionNumber) {
        this.objectVersionNumber = objectVersionNumber;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getAttributeCategory() {
        return attributeCategory;
    }

    public void setAttributeCategory(String attributeCategory) {
        this.attributeCategory = attributeCategory;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }

    public String getAttribute4() {
        return attribute4;
    }

    public void setAttribute4(String attribute4) {
        this.attribute4 = attribute4;
    }

    public String getAttribute5() {
        return attribute5;
    }

    public void setAttribute5(String attribute5) {
        this.attribute5 = attribute5;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, TO_STRING_STYLE);
    }

    private static final ToStringStyle TO_STRING_STYLE = new StandardToStringStyle() {
        @Override
        public void append(StringBuffer buffer, String fieldName, Object value, Boolean fullDetail) {
            if (value == null) {
                return;
            }
            if (fieldName.startsWith("_")) {
                return;
            }
            if (value instanceof Date) {
                value = DateFormatUtils.format((Date) value, BaseConstants.DATE_TIME_FORMAT,
                        TimeZoneUtil.getTimeZone());
            }
            super.append(buffer, fieldName, value, fullDetail);
        }
    };
}
