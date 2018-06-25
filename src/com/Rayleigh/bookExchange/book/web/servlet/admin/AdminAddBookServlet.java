package com.Rayleigh.bookExchange.book.web.servlet.admin;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.Rayleigh.bookExchange.book.domain.Book;
import com.Rayleigh.bookExchange.book.service.BookService;
import com.Rayleigh.bookExchange.category.domain.Category;
import com.Rayleigh.bookExchange.category.service.CategoryService;

import cn.itcast.commons.CommonUtils;

/**
 * Servlet implementation class AdminAddBookServlet
 */
@WebServlet("/admin/AdminAddBookServlet")
public class AdminAddBookServlet extends HttpServlet 
{
	private BookService bookService = new BookService();
	private CategoryService categoryService = new CategoryService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);

		try 
		{
			List<FileItem> fileItemList = sfu.parseRequest(request);
			Map<String,String> map = new HashMap<String,String>();
			for(FileItem fileItem : fileItemList) 
				if(fileItem.isFormField()) 
					map.put(fileItem.getFieldName(), fileItem.getString("UTF-8"));

			Book book = CommonUtils.toBean(map, Book.class);
			book.setBid(CommonUtils.uuid());
			book.setDel(false);

			Category category = CommonUtils.toBean(map, Category.class);
			book.setCategory(category);
			
			String savepath = this.getServletContext().getRealPath("/book_img");
			String filename = CommonUtils.uuid() + "_" + fileItemList.get(1).getName();
			
			if(!filename.toLowerCase().endsWith("jpg")) 
			{
				request.setAttribute("msg", "您上传的图片不是JPG扩展名！");
				request.setAttribute("categoryList", categoryService.findAll());
				request.getRequestDispatcher("/adminjsps/admin/book/add.jsp")
						.forward(request, response);
				return;
			}
			
			File destFile = new File(savepath, filename);
			fileItemList.get(1).write(destFile);
			
			book.setImage("book_img/" + filename);
			
			bookService.add(book);
			
			Image image = new ImageIcon(destFile.getAbsolutePath()).getImage();
			if(image.getWidth(null) > 400 || image.getHeight(null) > 400) 
			{
				destFile.delete();
				request.setAttribute("msg", "您上传的图片尺寸超出了400 * 400！");
				request.setAttribute("categoryList", categoryService.findAll());
				request.getRequestDispatcher("/adminjsps/admin/book/add.jsp")
						.forward(request, response);
				return;
			}
			
			request.getRequestDispatcher("/admin/AdminBookServlet?method=findAll")
					.forward(request, response);
		} catch (Exception e) 
		{ 
			e.printStackTrace();
		}
	}

}
