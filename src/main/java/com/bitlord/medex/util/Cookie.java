package com.bitlord.medex.util;

import com.bitlord.medex.db.Database;
import com.bitlord.medex.dto.User;

public class Cookie {

    public static User selectedUser = Database.userTable.get( 1 );  // default value ---> null

}
