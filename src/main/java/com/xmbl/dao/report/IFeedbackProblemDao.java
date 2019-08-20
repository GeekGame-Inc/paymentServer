package com.xmbl.dao.report;

import com.xmbl.model.problem.FeedbackProblem;
import com.xmbl.mongo.dao.GeneralDao;

/**
 * @author: sunbenbao
 * @Email: 1402614629@qq.com
 * @类名:  IReportDao 
 * @创建时间:  2017年12月27日 下午12:36:46
 * @修改时间:  2017年12月27日 下午12:36:46
 * @类说明:
 */
public interface IFeedbackProblemDao extends GeneralDao<FeedbackProblem>{

	FeedbackProblem add(FeedbackProblem feedbackProblem);

}
