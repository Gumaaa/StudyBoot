package com.gm.home.util;

import lombok.Data;

@Data
public class Pager {


	
	private Long page;
	private Long perPage; // perPage : 한페이지에 출력할 글의 갯수
	private Long perBlock; // perBlock: 한페이지에 출력할 번호의 갯수
	private Long startRow; // mapper에서 사용 / num는 jsp에서 사용

	public void getRowNum()throws Exception{
		this.startRow = (this.getPage()-1) * this.getPerPage();
	}
	
	public Pager() {
		this.perPage = 10L;
		this.perBlock = 5L;
	}
	
	public Long getPage() {
		if(this.page == null || this.page < 1) {
			this.page = 1L;
		}
		
		return page;
	}
	
	public Long getPerPage() {
		if(this.perPage == null) {
			this.perPage = 10L;
		}
		
		return perPage;
	}
	
	
}
