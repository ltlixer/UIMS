package com.lixer.uims.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lixer.uims.config.UserRole;
import com.lixer.uims.entity.Experiment;
import com.lixer.uims.entity.ExperimentReport;
import com.lixer.uims.entity.User;
import com.lixer.uims.service.CourseService;
import com.lixer.uims.service.ExperimentReportService;
import com.lixer.uims.service.ExperimentService;

@Controller
@RequestMapping("/experiment")
public class ExperimentController {
	@Autowired
	private ExperimentService experimentService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private ExperimentReportService experimentReportService;
	private static final Logger logger = LoggerFactory.getLogger(ExperimentController.class);

	/**
	 * 加载课程的实验列表
	 * 
	 * @return
	 */
	@RequestMapping("/list/{courseId}")
	public String listExperiment(@PathVariable("courseId") int courseId, ModelMap model, HttpSession session,
			HttpServletRequest request) {
		logger.info("course list page");
		List<Experiment> experimentList = experimentService.getExperimentsByCourseId(courseId);
		model.addAttribute("experimentList", experimentList);
		model.addAttribute("course", courseService.getCourseById(courseId));
		return "experiment/experiment-list";
	}

	/**
	 * 加载实验内容
	 * 
	 * @return
	 */
	@RequestMapping("/content/{experimentId}")
	public String listExperimentContent(@PathVariable("experimentId") int experimentId, ModelMap model,
			HttpSession session, HttpServletRequest request) {
		logger.info("experiment content page");
		// 实验内容
		Experiment experiment = experimentService.getExperimentById(experimentId);
		model.addAttribute("experiment", experiment);
		model.addAttribute("course",experiment.getCourse());
		// 实验报告列表
		List<ExperimentReport> experimentReportList = experimentReportService
				.getExperimentReportsByExperimentId(experimentId);
		model.addAttribute("experimentReportList", experimentReportList);
		User user = (User) session.getAttribute("user");
		if(UserRole.STUDENT.equals(user.getRole())){
			ExperimentReport experimentReport = experimentReportService.geExperimentReport(user.getId(), experimentId);
			model.addAttribute("myExperimentReport",experimentReport);
		}
		return "experiment/experiment-content";
	}

	/**
	 * 跳转到添加实验界面
	 * 
	 * @return
	 */
	@RequestMapping("/{courseId}/add")
	public ModelAndView linkToAddExperiment(@PathVariable("courseId") int courseId, ModelMap model, HttpSession session,
			HttpServletRequest request) {
		logger.info("course list page");
		Experiment experiment = new Experiment();
		experiment.setCourse(courseService.getCourseById(courseId));
		return new ModelAndView("experiment/experiment-add", "experiment", experiment);
	}

	/**
	 * 添加实验
	 * 
	 * @return
	 */
	@RequestMapping("/{courseId}/addExperiment")
	public String addExperiment(@PathVariable("courseId") int courseId,
			@ModelAttribute("experiment") Experiment experiment, ModelMap model, HttpSession session,
			HttpServletRequest request) {
		logger.info("course list page");
		experiment.setCourse(courseService.getCourseById(courseId));
		experimentService.addExperiment(experiment);
		return "redirect:/experiment/list/" + courseId;
	}

	/**
	 * 删除实验
	 * 
	 * @return
	 */
	@RequestMapping("/delete/{experimentId}")
	public String deleteExperiment(@PathVariable("experimentId") int experimentId,
			@ModelAttribute("experiment") Experiment experiment, ModelMap model, HttpSession session,
			HttpServletRequest request) {
		logger.info("course list page");
		int courseId = experimentService.getExperimentById(experimentId).getCourse().getId();
		experimentService.deleteExperimentByExperimentId(experimentId);
		return "redirect:/experiment/list/" + courseId;
	}

}
