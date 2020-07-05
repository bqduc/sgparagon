
package net.brilliant.entity.emx;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import net.brilliant.framework.entity.RepoEntity;

/**
 * 
 * @author MOHAMMED BOUNAGA
 * 
 * github.com/medbounaga
 */
@Entity
@Table(name = "account")
@NamedQueries({
    @NamedQuery(name = "Account.findByType", query = "SELECT a FROM EnterpriseAccount a WHERE a.type = :type"),         
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM EnterpriseAccount a"),
    @NamedQuery(name = "Account.findById", query = "SELECT a FROM EnterpriseAccount a WHERE a.id = :id"),
    @NamedQuery(name = "Account.findByName", query = "SELECT a FROM EnterpriseAccount a WHERE a.title = :name"),
    @NamedQuery(name = "Account.findByActive", query = "SELECT a FROM EnterpriseAccount a WHERE a.active = :active")})
public class EnterpriseAccount extends RepoEntity {
    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256, message = "{LongString}")
    @Column(name = "name")
    private String name; 

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100, message = "{LongString}")
    @Column(name = "title")
    private String title;    

    @NotNull
    @Basic(optional = false)
    @Size(max = 64, message = "{LongString}")
    @Column(name = "type")
    private String type;

    @NotNull
    @Basic(optional = false)
    @Size(max = 64, message = "{LongString}")
    @Column(name = "code")
    private String code;    

    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private Boolean active;

    @OneToMany(mappedBy = "account")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<JournalItem> journalItems;

    @OneToMany(mappedBy = "account")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<InvoiceLine> invoiceLines;

    @OneToMany(mappedBy = "account")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<InvoiceTax> invoiceTaxes;

    @OneToMany(mappedBy = "account")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<EnterprisePayment> payments;

    @OneToMany(mappedBy = "account")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<CustomerInvoice> invoices;

    public EnterpriseAccount() {
    }

    public EnterpriseAccount(String code, String name, String title, String type, Boolean active) {
        this.code = code;
        this.type = type;
        this.title = title;
        this.name = name;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<JournalItem> getJournalItems() {
        return journalItems;
    }

    public void setJournalItems(List<JournalItem> journalItems) {
        this.journalItems = journalItems;
    }

    public List<InvoiceLine> getInvoiceLines() {
        return invoiceLines;
    }

    public void setInvoiceLines(List<InvoiceLine> invoiceLines) {
        this.invoiceLines = invoiceLines;
    }

    public List<InvoiceTax> getInvoiceTaxes() {
        return invoiceTaxes;
    }

    public void setInvoiceTaxes(List<InvoiceTax> invoiceTaxes) {
        this.invoiceTaxes = invoiceTaxes;
    }
    
    public List<EnterprisePayment> getPayments() {
        return payments;
    }

    public void setPayments(List<EnterprisePayment> payments) {
        this.payments = payments;
    }

    public List<CustomerInvoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<CustomerInvoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public String toString() {
        return "Account[ id=" + getId() + " ]";
    }
    
}
