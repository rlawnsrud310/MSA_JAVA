package Day08.Ex02_Multillmplement;

//검색 인터페이스
public interface Searchable {

	// 채널 검색
	// : 검색어에 해당하는 채널번호를 반환
	int channelSearch(String keyword);
	
	// 컨텐츠 검색
	// : 검색어에 해당하는 컨텐츠 반환
	String[] contentSerach(String keyword);
}
