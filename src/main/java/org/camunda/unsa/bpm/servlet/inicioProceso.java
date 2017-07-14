package org.camunda.unsa.bpm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.engine.task.TaskQuery;
import org.camunda.bpm.model.bpmn.BpmnModelInstance;

/**
 * Servlet implementation class inicioProceso
 */
@WebServlet("/inicioProceso")
public class inicioProceso extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public inicioProceso() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// ProcessEngine processEngine =
		// BpmPlatform.getProcessEngineService().getProcessEngine("default");
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		RuntimeService runtimeService = processEngine.getRuntimeService();

		TaskService ts = processEngine.getTaskService();

		RepositoryService rs = processEngine.getRepositoryService();
		List<ProcessDefinition> result = rs.createProcessDefinitionQuery().active().list();

		ProcessInstance instancia2 = runtimeService.startProcessInstanceByKey("Proceso2dfase");

//		TaskQuery query = ts.createTaskQuery()
//				.processInstanceId(instancia2.getProcessInstanceId())
//				.orderByTaskName()
//				.asc();
//
//		List<Task> tasks = query.list();
//
//		Map<String, Object> variables = new HashMap<String, Object>();
//
//		variables.put("externo", true);
//
//		int taskSize = tasks.size();
//		Task task = tasks.get(0);
//
//		ts.complete(task.getId(), variables);
//
//		query = ts.createTaskQuery().processInstanceId(instancia2.getProcessInstanceId()).orderByTaskName().asc();
//		tasks = query.list();
//		taskSize = tasks.size();
//
//		runtimeService.deleteProcessInstance(instancia2.getId(), "Evento fue finalizado");

		// String param = request.getParameter("id");
		// ProcessInstance instancia =
		// runtimeService.startProcessInstanceByKey("procesopagoCamundaFase2");
		// String keyprocess = instancia.getId();

		String proceso2Id = instancia2.getId();

		out.println("<HTML><HEAD><TITLE>Leyendo parámetros</TITLE></HEAD>");
		out.println("<BODY BGCOLOR=\"#fff\">");
		// out.println("Id Proceso 1: " + keyprocess+"<BR>");
		out.println("Id Proceso 2: " + proceso2Id + "<BR>");
		out.println("Los Procesos fueron iniciados Correctamente");
		out.println("</BODY></HTML>");
		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

// para ejecurtar el inicio del proceso escribir lo siguiente
// http://localhost:8080/Camunda2daFace/inicioProceso
// http://localhost:8080/Nombre del proyecto / clase java