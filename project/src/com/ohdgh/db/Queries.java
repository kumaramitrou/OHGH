package com.ohdgh.db;

public class Queries {
	static String checkCredentials = "select * from [dbo].[User] where [UserName] = ? and [Password] = ?";
}
