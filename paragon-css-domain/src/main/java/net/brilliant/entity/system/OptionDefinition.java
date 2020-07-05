/*
 * Copyleft 2007-2011 Ozgur Yazilim A.S.
 *
 * Distributable under LGPL license.
 * See terms of license at gnu.org.
 * http://www.gnu.org/licenses/lgpl.html
 *
 * www.tekir.com.tr
 * www.ozguryazilim.com.tr
 *
 */

package net.brilliant.entity.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import net.brilliant.framework.entity.RepoEntity;

/**
 * Uygulama içinde kullanılacak olan seçenekleri tanımlar.
 * Her seçenek namespace kuralları içinde bir key sahibi olacak : 
 * base.DefaultCCY
 * base.DefaultLang
 * base.DefaultCountry
 * payment.AutoSerial
 * payment.SerialBegin
 * payment.NumberBegin
 * v.b.
 * @author haky
 */
@Entity
@Table(name="option_definition")
public class OptionDefinition extends RepoEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3726589585729126625L;

		public enum DataType{ String, Integer, Float, Date, Time, DateTime, Boolean, ControlType, BigDecimal }

    @Column(name="od_key", nullable=false, unique=true, length=50)
    @NotNull
    @Size(max=50, min=1)
    private String key;
    
    @Column(name="user_base")
    private Boolean userBase;
    
    @Column(name="default_value")
    private String defaultValue;
    
    @Column(name="value_list")
    private String valueList;
    
    @Column(name="data_type")
    @Enumerated(EnumType.ORDINAL)
    private DataType dataType;
    
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Boolean getUserBase() {
        return userBase;
    }

    public void setUserBase(Boolean userBase) {
        this.userBase = userBase;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getValueList() {
        return valueList;
    }

    public void setValueList(String valueList) {
        this.valueList = valueList;
    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    @Override
    public String toString() {
        return "OptionDefinition[id=" + getId() + "]";
    }
    
}
