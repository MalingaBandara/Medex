package com.bitlord.medex.util;

import com.bitlord.medex.db.Database;
import com.bitlord.medex.dto.UserDto;

public class Cookie {

    public static UserDto selectedUser = Database.userTable.get( 1 );  // default value ---> null

}
