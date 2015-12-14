package com.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.commons.logging.Log;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.tomcat.jni.OS;

import com.constants.Constants;


public class MyStreamServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			preview(req,resp);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	   public void preview(HttpServletRequest req,HttpServletResponse resp) throws ClassNotFoundException, IOException
	  {
		   String fpath=req.getParameter("fpath");
		   if(fpath==null)
			   return;
			String filename=Constants.HDFSAddress+fpath;
			Configuration config=new Configuration();
			FileSystem fs = null; 
			FSDataInputStream in=null;
			try {
				fs = FileSystem.get(URI.create(filename),config);	
				in=fs.open(new Path(filename));
			} catch (IOException e) {
				e.printStackTrace();
			}
		   final long fileLen = fs.getFileStatus(new Path(filename)).getLen();     
		   String range=req.getHeader("Range");
		   resp.setHeader("Content-type","video/mp4");
		   OutputStream out=resp.getOutputStream();    
		     if(range==null)
		     {
		    	 filename=fpath.substring(fpath.lastIndexOf("/")+1);
		         resp.setHeader("Content-Disposition", "attachment; filename="+filename);
		         resp.setContentType("application/octet-stream");
		         resp.setContentLength((int)fileLen);
		    	 IOUtils.copyBytes(in, out, fileLen, false);
		     }
		     else
		     {
			    long start=Integer.valueOf(range.substring(range.indexOf("=")+1, range.indexOf("-")));
			    long count=fileLen-start;
			    long end;
			    if(range.endsWith("-"))
			    	  end=fileLen-1;
			    else
			    	  end=Integer.valueOf(range.substring(range.indexOf("-")+1));
			    String ContentRange="bytes "+String.valueOf(start)+"-"+end+"/"+String.valueOf(fileLen);
			    resp.setStatus(206);
			    resp.setContentType("video/mpeg4");
			    resp.setHeader("Content-Range",ContentRange);
			    in.seek(start);
			    try{
			        IOUtils.copyBytes(in, out, count, false);
			      }
			    catch(Exception e)
			      {
			    	  throw e;
			      }
		     }
	        in.close();
	        in = null;
	        out.close();
	        out = null;
	  }
}

	