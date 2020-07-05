package net.brilliant.mvp.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.TreeNode;

import net.brilliant.mvp.model.FacesDocument;
import net.brilliant.mvp.service.DocumentService;

/**
 * Created by rmpestano on 29/04/17.
 */
@ViewScoped
@Named
public class TreeTableMB implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = -1025438575939144506L;

	private TreeNode root;

	private FacesDocument selectedDocument;

	private TreeNode[] selectedNodes;

	@Inject
	private DocumentService service;

	@PostConstruct
	public void init() {
		root = service.createDocuments();
	}

	public TreeNode getRoot() {
		return root;
	}

	public TreeNode[] getSelectedNodes() {
		return selectedNodes;
	}

	public void setSelectedNodes(TreeNode[] selectedNodes1) {
		this.selectedNodes = selectedNodes1;
	}

	public void setService(DocumentService service) {
		this.service = service;
	}

	public FacesDocument getSelectedDocument() {
		return selectedDocument;
	}

	public void setSelectedDocument(FacesDocument selectedDocument) {
		this.selectedDocument = selectedDocument;
	}
}
