/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.tag;

import java.io.IOException;
import java.util.Base64;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author qwer1
 */
public class DisplayImageTag  extends SimpleTagSupport {
    private byte[] imageBytes;

    public void setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }

    @Override
    public void doTag() throws JspException, IOException {
        if (imageBytes != null) {
            String base64Image = Base64.getEncoder().encodeToString(imageBytes); // Replace the encoding
            JspWriter out = getJspContext().getOut();
            out.println("<img src=\"data:image/jpeg;base64," + base64Image + "\" alt=\"Image after createRecord\" />");
        }
    }
}
