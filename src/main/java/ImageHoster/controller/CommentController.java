package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.Tag;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import ImageHoster.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ImageService imageService;

    // Controller method for creating new comment
   @RequestMapping(value = "/image/{imageId}/{imageTitle}/comments", method = RequestMethod.POST)
    public String createComment(@RequestParam("comment") String comment,  @PathVariable int imageId, @PathVariable String imageTitle, HttpSession session, Model model) throws IOException {

        Image image = imageService.getImage(imageId);
        Comment cmt =new Comment();
        User user = (User) session.getAttribute("loggeduser");
        if( user!=null) {
        	cmt.setCreatedDate(new Date());
        	cmt.setText(comment);
        	cmt.setUser(user);
        	cmt.setImage(image);
        	commentService.addComment(cmt);
        }
        return "redirect:/images/" + imageId + "/" + imageTitle;

       
        	
        }
    }


  
 
