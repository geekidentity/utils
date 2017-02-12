package com.geekidentity.datastructures.graph;

public class Graph {
	
	private int numVertex;
	private int numEdge;
	//图的顶点访问标记
	private int[] mark;
	//存放图中顶点的入度
	private int inDegree;
	
	private static final int UNVISITED = -1;
	
	/**
	 * 
	 * @param graph
	 */
	public void traverse(Graph graph) {
		//对图所有顶点的标志位进行初始化
		for (int i = 0; i < graph.getVerticesNum(); i++) {
			graph.getMark()[i] = UNVISITED;
		}
		/*
		 * 检查图的所有顶点是否被标记过，如果未被标记，
		 * 则从该未被标记的顶点开始继续遍历
		 * doTraverse()函数使用深度或广度优先
		 */
		for (int i = 0; i < graph.getVerticesNum(); i++) {
			if (graph.getMark()[i] == UNVISITED) {
				doTraverse(graph, i);
			}
		}
	}
	
	private void doTraverse(Graph graph, int i) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 返回图的顶点个数
	 * @return
	 */
	public int getVerticesNum() {
		return numVertex;
	}
	
	/**
	 * 返回图的边数
	 * @return
	 */
	public int getEdgesNum() {
		return numEdge;
	}
	
	/**
	 * 
	 * @param oneVertex
	 * @return 第一条关联边
	 */
	public Edge getFirstEdge(int oneVertex) {
		return null;
	}
	
	/**
	 * @param preEdge
	 * @return 下一条兄弟边
	 */
	public Edge getNextEdge(Edge preEdge) {
		return null;
	}
	
	/**
	 * 添加一条边
	 * @param fromVertex
	 * @param toVertex
	 * @param weight
	 * @return
	 */
	public boolean setEdge(int fromVertex, int toVertex, int weight) {
		return false;
	}
	
	/**
	 * 删除一条边
	 * @return
	 */
	public boolean deleteEdge(int fromVertex, int toVertex) {
		return false;
	}
	
	/**
	 * 
	 * @param edge
	 * @return
	 */
	public boolean isEdge(Edge edge) {
		return false;
	}
	
	/**
	 * 返回边的始点
	 * @param edge
	 * @return
	 */
	public int fromVertex(Edge edge) {
		return 0;
	}
	
	/**
	 * 返回边的终点
	 * @param edge
	 * @return
	 */
	public int toVertex(Edge edge) {
		return 0;
	}
	
	/**
	 * 返回边的权
	 * @param edge
	 * @return
	 */
	public int weight(Edge edge) {
		return 0;
	}

	public int[] getMark() {
		return mark;
	}

	public void setMark(int[] mark) {
		this.mark = mark;
	}
}

class Edge {
	private int from, to, weigth;
	public Edge() {
		from = -1; to = -1; weigth = 0;
	}
	public Edge(int from, int to, int weigth) {
		this.from = from;
		this.to = to;
		this.weigth = weigth;
	}
	public int getFrom() {
		return from;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	public int getTo() {
		return to;
	}
	public void setTo(int to) {
		this.to = to;
	}
	public int getWeigth() {
		return weigth;
	}
	public void setWeigth(int weigth) {
		this.weigth = weigth;
	}
	
}
