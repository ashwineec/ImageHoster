package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.repository.CommentRepository;
import ImageHoster.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;



    //The method calls the addComment from repository
    public void addComment(Comment cmt) {
        commentRepository.addComment(cmt);
    }



	public List<Comment> getAllComments(int imageId) {
		// TODO Auto-generated method stub
		return commentRepository.getAllComments(imageId);
	}




}
