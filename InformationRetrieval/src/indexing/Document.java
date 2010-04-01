/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package src.indexing;

import java.util.ArrayList;

/**
 *
 * @author msenesi
 */
public class Document {
    public Integer id;
    public ArrayList<TermPosting> terms;

    public Document(Integer id) {
        this.id = id;
        this.terms = new  ArrayList<TermPosting>();
    }



}
