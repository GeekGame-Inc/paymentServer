package com.xmbl.service.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmbl.dao.comments.ICommentsTypeDao;
import com.xmbl.dao.impl.comments.CommentsTypeDaoImpl;


/**
 * @author: sunbenbao
 * @Email: 1402614629@qq.com
 * @类名:  CommentTypeService 
 * @创建时间:  2018年5月7日 下午5:28:34
 * @修改时间:  2018年5月7日 下午5:28:34
 * @类说明:
 */
@Service
public class CommentTypeService extends CommentsTypeDaoImpl{

	@Autowired
	private ICommentsTypeDao iCommentsTypeDao;
	
	public Boolean hasCommentType(String comment_parent_type) {
		return iCommentsTypeDao.hasCommentType(comment_parent_type);
	}

}
