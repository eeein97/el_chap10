package utils;

public class BoardPaging {
	public static String pagingStr(int totalCount, int pageSize, int blockPage, int pageNum, String reqUrl) {
		String pagingStr = "";
		
		//전체페이지 수		전체레코드수 / 한페이지당 래코드수
		int totalpages = (int) Math.ceil((double) totalCount / pageSize);
		//이전페이지 블록 바로가기
		int pageTemp = (((pageNum-1)/blockPage)*blockPage) + 1;
		if(pageTemp != 1) {
			pagingStr += "<a href='"+reqUrl+"?pageNum=1'>[첫페이지]</a>";
			pagingStr += "<a href='"+reqUrl+"?pageNum="+(pageTemp-1)+"'>[이전]</a>";
		}
		//각 페이지 번호 출력
		int blockcount = 1;
		while(blockcount <= blockPage && pageTemp <= totalpages) {
			//현재 페이지는 링크를 걸지않음
			if(pageTemp == pageNum) {
				pagingStr += " "+pageTemp+" ";
			}else {
				pagingStr += "<a href='"+reqUrl+"?pageNum="+pageTemp+"'>"+pageTemp+"</a>";
			}
			pageTemp++;
			blockcount++;
		}
		
		//마지막페에지, 다음블록 출력
		if(pageTemp <= totalpages) {
			pagingStr += "<a href='"+reqUrl+"?pageNum="+pageTemp+"'>[다음]</a>";
			pagingStr += "<a href='"+reqUrl+"?pageNum="+totalpages+"'>[마지막페이지]</a>";
		}
		
		
		return pagingStr;
	}
}
