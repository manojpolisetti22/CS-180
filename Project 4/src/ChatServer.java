import java.util.*;
import java.util.regex.*;

/**
 * <b> CS 180 - Project 4 - Chat Server Skeleton </b>
 * <p>
 * 
 * This is the skeleton code for the ChatServer Class. This is a private chat
 * server for you and your friends to communicate.
 * 
 * @author (Vinson Luo) <(vluo@purdue.edu)>, (Manoj Polisetti) <(mpoliset@purdue.edu)>
 *
 * @lab (Vinson, BR8), (Manoj, BR8)
 * 
 * @version (17 November, 2015)
 *
 */
public class ChatServer {

	private User[] users;
	private int initialSize;
	private int currentSize;
	private int maxSize = 100;
	private int maxMessages;
    private CircularBuffer cbfr;

	public ChatServer(User[] users, int maxMessages) {
		this.users = users;
        this.initialSize = this.users.length;
		this.currentSize = this.initialSize;
		this.users = Arrays.copyOf(this.users, currentSize + 1);
		this.users[users.length] = new User("root", "cs180", null);
		this.currentSize = this.currentSize + 1;
		this.maxMessages = maxMessages;
        cbfr = new CircularBuffer(maxMessages);
	}

	/**
	 * This method begins server execution.
	 */
	public void run() {
		boolean verbose = false;
		System.out.printf("The VERBOSE option is off.\n\n");
		Scanner in = new Scanner(System.in);

		while (true) {
			System.out.printf("Input Server Request: ");
			String command = in.nextLine();

			// this allows students to manually place "\r\n" at end of command
			// in prompt
			command = replaceEscapeChars(command);

			if (command.startsWith("kill"))
				break;

			if (command.startsWith("verbose")) {
				verbose = !verbose;
				System.out.printf("VERBOSE has been turned %s.\n\n", verbose ? "on" : "off");
				continue;
			}

			String response = null;
			try {
				response = parseRequest(command);
			} catch (Exception ex) {
				response = MessageFactory.makeErrorMessage(MessageFactory.UNKNOWN_ERROR,
						String.format("An exception of %s occurred.", ex.getMessage()));
			}

			// change the formatting of the server response so it prints well on
			// the terminal (for testing purposes only)
			if (response.startsWith("SUCCESS\t"))
				response = response.replace("\t", "\n");

			// print the server response
			if (verbose)
				System.out.printf("response:\n");
			System.out.printf("\"%s\"\n\n", response);
		}

		in.close();
	}

	/**
	 * Replaces "poorly formatted" escape characters with their proper values.
	 * For some terminals, when escaped characters are entered, the terminal
	 * includes the "\" as a character instead of entering the escape character.
	 * This function replaces the incorrectly inputed characters with their
	 * proper escaped characters.
	 * 
	 * @param str
	 *            - the string to be edited
	 * @return the properly escaped string
	 */
	private static String replaceEscapeChars(String str) {
		str = str.replace("\\r", "\r");
		str = str.replace("\\n", "\n");
		str = str.replace("\\t", "\t");

		return str;
	}

	/**
	 * Determines which client command the request is using and calls the
	 * function associated with that command.
	 * 
	 * @param request
	 *            - the full line of the client request (CRLF included)
	 * @return the server response
	 */
	public String parseRequest(String request) {
        if (request.endsWith("\r\n")) {
            request = request.substring(0, request.length() - 2);
        } else {
            return MessageFactory.makeErrorMessage(10);
        }
		String[] split = request.split("\t");
        String s = "";
        if (split[0].equals("ADD-USER")) {
            if (split.length == 4) {
                for (int i = 0; i < currentSize; i++) {
                    if (this.users[i].getCookie() == null) {
                        continue;
                    } else if ((this.users[i].getCookie().getID()) == (Long.parseLong(split[1]))) {
                        if (this.users[i].getCookie().hasTimedOut()) {
                            this.users[i].setCookie(null);
                            return MessageFactory.makeErrorMessage(05);
                        }
                        s += addUser(split);
                        this.users[i].getCookie().updateTimeOfActivity();
                        return s;
                    }
                }
                return MessageFactory.makeErrorMessage(23);
            } else {
                return MessageFactory.makeErrorMessage(10);
            }
        } else if (split[0].equals("POST-MESSAGE")) {

            if (split.length == 3) {
                try {
                    Long.parseLong(split[1]);
                } catch (NumberFormatException e) {
                    return MessageFactory.makeErrorMessage(24);
                }
                for (int i = 0; i < currentSize; i++) {
                    if (this.users[i].getCookie() == null) {
                        continue;
                    } else if ((this.users[i].getCookie().getID()) == (Long.parseLong(split[1]))) {
                        if (this.users[i].getCookie().hasTimedOut()) {
                            this.users[i].setCookie(null);
                            return MessageFactory.makeErrorMessage(05);
                        }
                        s += postMessage(split, this.users[i].getName());
                        this.users[i].getCookie().updateTimeOfActivity();
                        return s;
                    }
                }
                return MessageFactory.makeErrorMessage(23);
            } else {
                return MessageFactory.makeErrorMessage(10);
            }
        } else if (split[0].equals("GET-MESSAGES")) {
            if (split.length == 3) {
				for (int i = 0; i < currentSize; i++) {
					if (this.users[i].getCookie() == null) {
						continue;
					} else if ((this.users[i].getCookie().getID()) == (Long.parseLong(split[1]))) {
                        if (this.users[i].getCookie().hasTimedOut()) {
                            this.users[i].setCookie(null);
                            return MessageFactory.makeErrorMessage(05);
                        }
                        s += getMessages(split);
                        return s;
                    }
                }
                return MessageFactory.makeErrorMessage(23);
            } else {
                return MessageFactory.makeErrorMessage(10);
            }
        } else if (split[0].equals("USER-LOGIN")) {
            if (split.length == 3) {
                for (int i = 0; i < currentSize; i++) {
                    if (this.users[i].getName().equals(split[1])) {
                        if ((this.users[i].getCookie()) != null) {
                            s += userLogin(split);
                            this.users[i].getCookie().updateTimeOfActivity();
                            return s;
                        } else {
                            return MessageFactory.makeErrorMessage(25);
                        }
                    }
                    return MessageFactory.makeErrorMessage(20);
                }
            } else {
                return MessageFactory.makeErrorMessage(10);
            }
        }
        return MessageFactory.makeErrorMessage(11);
	}
	public String postMessage(String[] args, String name) {
        String message = "";
        if (args[2].trim().length() > 0) {
            message += args[2].trim();
        } else {
            return MessageFactory.makeErrorMessage(24);
        }
		String completeMessage = name + ": " + message;
        cbfr.put(completeMessage);
		return "SUCCESS\r\n";
	}
	public String getMessages(String[] args) {
        int num;
        try {
            num = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            return MessageFactory.makeErrorMessage(24);
        }
        if (num < 1) {
            return MessageFactory.makeErrorMessage(24);
        }
        String[] mess = cbfr.getNewest(num);
        String result = "SUCCESS\t";
        for(int i = 0; i < mess.length; i++) {
            result += "" + mess[i];
            if (i < mess.length - 1) {
                result += "\t";
            }
        }
        result = result + "\r\n";
        return result;
	}
	public String addUser(String[] args) {
        for (int i = 0; i < users.length; i++) {
            if (users[i].getName().equals(args[2])) {
                return MessageFactory.makeErrorMessage(22);
            }
        }
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]*$");
        Matcher matcher = pattern.matcher(args[2]);
        Matcher matcher2 = pattern.matcher(args[3]);

		if (matcher.matches() && matcher2.matches()) {
			if (args[2].length() >= 1 && args[2].length() <= 20 && args[3].length() >= 4 && args[3].length() <= 40) {
				this.users = Arrays.copyOf(this.users, this.currentSize + 1);
				this.users[this.currentSize] = new User(args[2], args[3], null);
				this.currentSize = this.currentSize + 1;
				return "SUCCESS\r\n";
			} else {
				return MessageFactory.makeErrorMessage(24);
			}
		} else {
            return MessageFactory.makeErrorMessage(24);
        }
	}
	public String userLogin(String[] args) {
		SessionCookie sc;
		long id;
		Random r = new Random();

		for (int i = 0; i < users.length; i++) {
			if (args[1].equals(users[i].getName())) {
				if (users[i].checkPassword(args[2])) {
					id = Long.parseLong(String.format("%04d", r.nextInt(10000)));
					sc = new SessionCookie(id);
					users[i].setCookie(sc);
					return "SUCCESS\t" + id + "\r\n";
				} else {
					return MessageFactory.makeErrorMessage(21);
				}
			} else {
				continue;
			}
		}
		return MessageFactory.makeErrorMessage(20);
	}
}

