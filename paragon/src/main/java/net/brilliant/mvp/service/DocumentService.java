/*
 * Copyright 2009-2014 PrimeTek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.brilliant.mvp.service;

import java.io.Serializable;

import org.primefaces.model.CheckboxTreeNode;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.stereotype.Component;

import net.brilliant.mvp.model.FacesDocument;

@Component
public class DocumentService implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -1895408104324884077L;

		public TreeNode createDocuments() {
        TreeNode root = new DefaultTreeNode(new FacesDocument("Files", "-", "Folder"), null);
		
		TreeNode documents = new DefaultTreeNode(new FacesDocument("Documents", "-", "Folder"), root);
		TreeNode pictures = new DefaultTreeNode(new FacesDocument("Pictures", "-", "Folder"), root);
		TreeNode movies = new DefaultTreeNode(new FacesDocument("Movies", "-", "Folder"), root);
		
		TreeNode work = new DefaultTreeNode(new FacesDocument("Work", "-", "Folder"), documents);
		TreeNode primefaces = new DefaultTreeNode(new FacesDocument("PrimeFaces", "-", "Folder"), documents);
		
		//Documents
		TreeNode expenses = new DefaultTreeNode("document", new FacesDocument("Expenses.doc", "30 KB", "Word Document"), work);
		TreeNode resume = new DefaultTreeNode("document", new FacesDocument("Resume.doc", "10 KB", "Word Document"), work);
		TreeNode refdoc = new DefaultTreeNode("document", new FacesDocument("RefDoc.pages", "40 KB", "Pages Document"), primefaces);
		
		//Pictures
		TreeNode barca = new DefaultTreeNode("picture", new FacesDocument("barcelona.jpg", "30 KB", "JPEG Image"), pictures);
		TreeNode primelogo = new DefaultTreeNode("picture", new FacesDocument("logo.jpg", "45 KB", "JPEG Image"), pictures);
		TreeNode optimus = new DefaultTreeNode("picture", new FacesDocument("optimusprime.png", "96 KB", "PNG Image"), pictures);
		
		//Movies
		TreeNode pacino = new DefaultTreeNode(new FacesDocument("Al Pacino", "-", "Folder"), movies);
		TreeNode deniro = new DefaultTreeNode(new FacesDocument("Robert De Niro", "-", "Folder"), movies);
		
		TreeNode scarface = new DefaultTreeNode("mp3", new FacesDocument("Scarface", "15 GB", "Movie File"), pacino);
		TreeNode carlitosWay = new DefaultTreeNode("mp3", new FacesDocument("Carlitos' Way", "24 GB", "Movie File"), pacino);
		
		TreeNode goodfellas = new DefaultTreeNode("mp3", new FacesDocument("Goodfellas", "23 GB", "Movie File"), deniro);
		TreeNode untouchables = new DefaultTreeNode("mp3", new FacesDocument("Untouchables", "17 GB", "Movie File"), deniro);
        
        return root;
    }
    
    public TreeNode createCheckboxDocuments() {
        TreeNode root = new CheckboxTreeNode(new FacesDocument("Files", "-", "Folder"), null);
		
		TreeNode documents = new CheckboxTreeNode(new FacesDocument("Documents", "-", "Folder"), root);
		TreeNode pictures = new CheckboxTreeNode(new FacesDocument("Pictures", "-", "Folder"), root);
		TreeNode movies = new CheckboxTreeNode(new FacesDocument("Movies", "-", "Folder"), root);
		
		TreeNode work = new CheckboxTreeNode(new FacesDocument("Work", "-", "Folder"), documents);
		TreeNode primefaces = new CheckboxTreeNode(new FacesDocument("PrimeFaces", "-", "Folder"), documents);
		
		//Documents
		TreeNode expenses = new CheckboxTreeNode("document", new FacesDocument("Expenses.doc", "30 KB", "Word Document"), work);
		TreeNode resume = new CheckboxTreeNode("document", new FacesDocument("Resume.doc", "10 KB", "Word Document"), work);
		TreeNode refdoc = new CheckboxTreeNode("document", new FacesDocument("RefDoc.pages", "40 KB", "Pages Document"), primefaces);
		
		//Pictures
		TreeNode barca = new CheckboxTreeNode("picture", new FacesDocument("barcelona.jpg", "30 KB", "JPEG Image"), pictures);
		TreeNode primelogo = new CheckboxTreeNode("picture", new FacesDocument("logo.jpg", "45 KB", "JPEG Image"), pictures);
		TreeNode optimus = new CheckboxTreeNode("picture", new FacesDocument("optimusprime.png", "96 KB", "PNG Image"), pictures);
		
		//Movies
		TreeNode pacino = new CheckboxTreeNode(new FacesDocument("Al Pacino", "-", "Folder"), movies);
		TreeNode deniro = new CheckboxTreeNode(new FacesDocument("Robert De Niro", "-", "Folder"), movies);
		
		TreeNode scarface = new CheckboxTreeNode("mp3", new FacesDocument("Scarface", "15 GB", "Movie File"), pacino);
		TreeNode carlitosWay = new CheckboxTreeNode("mp3", new FacesDocument("Carlitos' Way", "24 GB", "Movie File"), pacino);
		
		TreeNode goodfellas = new CheckboxTreeNode("mp3", new FacesDocument("Goodfellas", "23 GB", "Movie File"), deniro);
		TreeNode untouchables = new CheckboxTreeNode("mp3", new FacesDocument("Untouchables", "17 GB", "Movie File"), deniro);
        
        return root;
    }
}
