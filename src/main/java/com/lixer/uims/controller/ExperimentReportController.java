package com.lixer.uims.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lixer.uims.entity.Experiment;
import com.lixer.uims.entity.ExperimentReport;
import com.lixer.uims.entity.User;
import com.lixer.uims.service.CourseService;
import com.lixer.uims.service.ExperimentReportService;
import com.lixer.uims.service.ExperimentService;

@Controller
@RequestMapping("/experiment-report")
public class ExperimentReportController {
	@Autowired
	private CourseService courseService;
	@Autowired
	private ExperimentService experimentService;
	@Autowired
	private ExperimentReportService experimentReportService;
	private static final Logger logger = LoggerFactory.getLogger(ExperimentReportController.class);

	/**
	 * 加载实验内容
	 * 
	 * @return
	 */
	@RequestMapping("/content/{experimentReportId}")
	public String listExperimentContent(@PathVariable("experimentReportId") int experimentReportId, ModelMap model,
			HttpSession session, HttpServletRequest request) {
		logger.info("experiment content page");
		// 实验报告
		ExperimentReport experimentReport = experimentReportService.getExperimentReportById(experimentReportId);
		model.addAttribute("experimentReport", experimentReport);
		model.addAttribute("course",experimentReport.getExperiment().getCourse());
		model.addAttribute("experiment",experimentReport.getExperiment());
		
		return "experiment-report/experiment-report-content";
	}

	/**
	 * 提交实验报告
	 * 
	 * @return
	 */
	@RequestMapping("/submitExperimentReport")
	public String submitExperimentReport(@RequestParam("file") MultipartFile[] files, ModelMap model,
			HttpSession session, HttpServletRequest request) {
		logger.info("course list page");
		if (files.length != 0 && files != null) {
			String fileName = files[0].getOriginalFilename();
			User user = (User) session.getAttribute("user");
			int experimentId = Integer.parseInt(request.getParameter("experimentId"));
			int courseId = Integer.parseInt(request.getParameter("courseId"));
			ExperimentReport experimentReport = new ExperimentReport();
			experimentReport.setExperimentReportName(fileName.substring(0, fileName.lastIndexOf(".")));
			experimentReport.setExperimentReportUrl(request.getSession().getServletContext()
					.getRealPath("/upload/" + courseId + "/" + experimentId + "/" + user.getUsername() + "/"));
			experimentReport.setUser(user);
			experimentReport.setSubmitTime(System.currentTimeMillis());
			experimentReport.setExperiment(experimentService.getExperimentById(experimentId));
			experimentReportService.addExperimentReport(experimentReport, files[0]);

			Experiment experiment = experimentService.getExperimentById(experimentId);
			model.addAttribute("experiment", experiment);
			return "redirect:/experiment/content/"+experimentId;
		}else{
			return null;
		}
	}
	
	/**
	 * 下载实验报告
	 * 
	 * @return
	 */
	@RequestMapping("/download/{experimentReportId}")
	public String downloadExperimentReport(@PathVariable("experimentReportId") int experimentReportId, ModelMap model,
			HttpSession session, HttpServletRequest request,HttpServletResponse response) {
		logger.info("download ExperimentReport");
		
		experimentReportService.downloadExperimentReport(experimentReportId, response);
		
		return null;
	}
	
	/**
	 * 给实验报告打分
	 * 
	 * @return
	 */
	@RequestMapping("/score/{experimentReportId}")
	public String scoreExperimentReport(@PathVariable("experimentReportId") int experimentReportId, ModelMap model,
			HttpSession session, HttpServletRequest request,HttpServletResponse response) {
		logger.info("download ExperimentReport");
		int score = Integer.parseInt(request.getParameter("score"));
		ExperimentReport experimentReport = experimentReportService.getExperimentReportById(experimentReportId);
		experimentReport.setScore(score);
		experimentReport.setStatus(true);
		experimentReportService.updateExperimentReport(experimentReport);
		System.out.println(score);
		
		return "redirect:/experiment-report/content/"+experimentReportId;
	}
	
	/**
	 * 删除实验报告
	 * 
	 * @return
	 */
	@RequestMapping("/delete/{experimentReportId}")
	public String deleteExperiment(@PathVariable("experimentReportId") int experimentReportId,
			 ModelMap model, HttpSession session,HttpServletRequest request) {
		logger.info("experimentReport delete");
		int experimentId = experimentReportService.getExperimentReportById(experimentReportId).getExperiment().getId();
		experimentReportService.deleteExperimentReport(experimentReportId);
		return "redirect:/experiment/content/"+experimentId;
	}
}
