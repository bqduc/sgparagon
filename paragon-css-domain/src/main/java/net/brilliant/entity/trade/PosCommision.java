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

package net.brilliant.entity.trade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import net.brilliant.framework.entity.RepoAuditable;

/**
 * Poslar için komisyon oranlarını tutan modelimizdir.
 * @author sinan.yumak
 *
 */
@Entity
@Table(name="POS_COMMISION")
public class PosCommision extends RepoAuditable {
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true/*, fetch = FetchType.EAGER*/)
	private List<PosCommisionDetail> detailList = new ArrayList<PosCommisionDetail>();

    /**
     * komisyonun bağlı olduğu pos bilgisini tutar.
     */
    @ManyToOne
    @JoinColumn(name="POS_ID")
    private Pos pos;

    /**
     * komisyon geçerlilik başlangıç tarihi
     */
    @Column(name="START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    
    /**
     * komisyon geçerlilik bitiş tarihi
     */
    @Column(name="END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PosCommision)) {
            return false;
        }
        PosCommision other = (PosCommision)object;
        if (this.getId() != other.getId() && (this.getId() == null || !this.getId().equals(other.getId()))) return false;
        return true;
    }

    @Override
    public String toString() {
        return "PosCommision[id=" + getId() + "]";
    }

    public PosCommisionDetail getDefaultDetail() {
    	for (PosCommisionDetail item : detailList) {
    		if (item.getDefaultDetail()) return item;
    	}
    	return null;
    }

	public List<PosCommisionDetail> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<PosCommisionDetail> detailList) {
		this.detailList = detailList;
	}

	public Pos getPos() {
		return pos;
	}

	public void setPos(Pos pos) {
		this.pos = pos;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
