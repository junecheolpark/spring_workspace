package kh.board.member;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/*
 *  dao를 통해 데이터를 추가, 수정, 삭제, 조회해야하는 경우 메서드 생성
 *  혹은 요청/응답과는 별개로 추가적으로 가공해야하는 데이터가 있는 경우
 * */
/*
 * 컨트롤러-> 클라이언트로부터 직접으로 요청을 받고 그 요청에따라
 * 추가적인 데이터 가공이 필요하거나, 혹은 db를 통해 데이터
 * 수정/삭제/조회/추가ㅣ 해야 하는 경우 controller가 직접 dao 를 호출하지 않고
 * service에게 그 작업을 전달함
 * -> 그럼 service의 호출된 메서드가 추가적으로 처리해야하는 가공이나 dao 호출을 통해
 * 비지니스 ㄱ로직을 수행하고 그에 따른 결과값만 바로 controller에게 전달해줌.
 * -> controller는 결과값을 받아서 판단에 따라 응답값을 어떻게 클라이언트에 되돌려 줄지 결정한다
 * 
 * 즉 controller는 클라이언틍의 요청과 응답과 관련된 직접적인 일들만 처리ㅏ
 * 나머지 뒤에서 보이지 않는 일들은 서비스가 처리.
 * */
@Service
public class MemberService {
	@Autowired
	private MemberDAO dao;

	public MemberDTO login(String id, String pw) throws Exception {
		return dao.login(id, pw);
	}

	public boolean idCheck(String id) throws Exception {
		return dao.checkID(id);
	}

	public int signup(MemberDTO dto
	/* , MultipartFile file, String realPath */) throws Exception {

//		File realPathFile = new File(realPath);
//		if(!realPathFile.exists()) realPathFile.mkdir();
//		/* 파일 데이터는 MultipartFile 형 변수로 받아줌.
//		 * MultipartFile 형 변수의 이름은 클라이언트에서 넘겨주는 파일태그의 이름
//		 * MultipartFile을 받아줄때에는 반드시 함께 받아주는 일반데이터의 멤버필드명과 겹치지 않도록 함. 
//		 * */
//		
//		if(!file.isEmpty()) { // 클라이언트로부터 넘어 온 파일이 있다면
//			// 우리가 직접 만들어준 sys_name 을 이용해 파일을 업로드할 것.
//			/* UUID (고유식별값) 
//			 *  ori_name 활용
//			 *  ~~~~_ori_name */
//			String ori_name = file.getOriginalFilename();
//			System.out.println("ori_name : " + ori_name);
//			String sys_name = UUID.randomUUID() + "_" + ori_name;
//			System.out.println("sys_name : " + sys_name);
//			// transferTo(실제 파일이 저장될 full 경로->파일 객체를 이용) -> MultipartFile객체가 담고 있는 
//			// 파일데이터를 인자값으로 넘겨준 경로에 실제 저장(업로드)해주는 역할을 함. 
//			file.transferTo(new File(realPath + File.separator + sys_name));
//			
//			
//			dto.setProfile_image(sys_name); // dto에 프로필 경로도 셋팅해주기
//		}
//		// pw 암호화 적용 

		return dao.insert(dto);
	}
	//파일 업로드
	public String uploadProfile(MultipartFile file, String realPath) throws Exception {
		File realPathFile = new File(realPath);
		if (!realPathFile.exists())
			realPathFile.mkdir();
		String ori_name = file.getOriginalFilename();
		String sys_name = UUID.randomUUID() + "_" + ori_name;
		file.transferTo(new File(realPath + File.separator + sys_name));
		return sys_name;

	}

	// 이미지,메세지 수정
	public int modifyProfile(MemberDTO dto) throws Exception {
		return dao.modifyProfile(dto);
	}
	// 닉네임 수정
	public int modify_nickname(MemberDTO dto) throws Exception {
		return dao.modify_nickname(dto);
	}
}
