package com.internousdev.cherry.dto.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.internousdev.cherry.dto.UserInfoDTO;

public class UserInfoDTOTest {



	//自動生成IDに関するテスト
	@Test
	public void testGetId1() {
		UserInfoDTO dto = new UserInfoDTO();
		int expected = 0;

		dto.setId(expected);

		assertEquals(expected, dto.getId());

	}
	@Test
	public void testGetId2() {
		UserInfoDTO dto = new UserInfoDTO();
		int expected = 2147483647;

		dto.setId(expected);

		assertEquals(expected, dto.getId());
	}
	@Test
	public void testGetId3() {
		UserInfoDTO dto = new UserInfoDTO();
		int expected = -2147483647;

		dto.setId(expected);

		assertEquals(expected, dto.getId());
	}
	@Test
	public void testGetId4() throws Exception {
		UserInfoDTO dto = new UserInfoDTO();
	    try{
	    	int postalMax = Integer.parseInt("2147483648");
	    	dto.setId(postalMax);

	    } catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
	    }
	}
	@Test
	public void testGetId5() throws Exception {
		UserInfoDTO dto = new UserInfoDTO();
		try {
		     int postalMin = Integer.parseInt("-2147483649");
		     dto.setId(postalMin);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}



























/*	@Test
	public void testGetId() {
		fail("まだ実装されていません");
	}

	@Test
	public void testSetId() {
		fail("まだ実装されていません");
	}

	@Test
	public void testGetUserId() {
		fail("まだ実装されていません");
	}

	@Test
	public void testSetUserId() {
		fail("まだ実装されていません");
	}

	@Test
	public void testGetPassword() {
		fail("まだ実装されていません");
	}

	@Test
	public void testSetPassword() {
		fail("まだ実装されていません");
	}

	@Test
	public void testGetFamilyName() {
		fail("まだ実装されていません");
	}

	@Test
	public void testSetFamilyName() {
		fail("まだ実装されていません");
	}

	@Test
	public void testGetFirstName() {
		fail("まだ実装されていません");
	}

	@Test
	public void testSetFirstName() {
		fail("まだ実装されていません");
	}

	@Test
	public void testGetFamilyNameKana() {
		fail("まだ実装されていません");
	}

	@Test
	public void testSetFamilyNameKana() {
		fail("まだ実装されていません");
	}

	@Test
	public void testGetFirstNameKana() {
		fail("まだ実装されていません");
	}

	@Test
	public void testSetFirstNameKana() {
		fail("まだ実装されていません");
	}

	@Test
	public void testIsSex() {
		fail("まだ実装されていません");
	}

	@Test
	public void testSetSex() {
		fail("まだ実装されていません");
	}

	@Test
	public void testGetEmail() {
		fail("まだ実装されていません");
	}

	@Test
	public void testSetEmail() {
		fail("まだ実装されていません");
	}

	@Test
	public void testIsStatus() {
		fail("まだ実装されていません");
	}

	@Test
	public void testSetStatus() {
		fail("まだ実装されていません");
	}

	@Test
	public void testIsLogined() {
		fail("まだ実装されていません");
	}

	@Test
	public void testSetLogined() {
		fail("まだ実装されていません");
	}

	@Test
	public void testGetRegister_date() {
		fail("まだ実装されていません");
	}

	@Test
	public void testSetRegister_date() {
		fail("まだ実装されていません");
	}

	@Test
	public void testGetUpdate_date() {
		fail("まだ実装されていません");
	}

	@Test
	public void testSetUpdate_date() {
		fail("まだ実装されていません");
	}

	@Test
	public void testSetUserName() {
		fail("まだ実装されていません");
	}*/

}
