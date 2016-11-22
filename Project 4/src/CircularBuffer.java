/**
 * @author (Vinson Luo) <(vluo@purdue.edu)>, (Manoj Polisetti) <(mpoliset@purdue.edu)>
 * @version (18 November, 2015)
 * @lab (Vinson, BR8), (Manoj, BR8)
 */
public class CircularBuffer {
    private int size;
    private int messageNumber;
    private String[] messages;
    private int countOne;
    private int countTwo;

    public CircularBuffer(int size) {
        this.size = size;
        this.messageNumber = 0;
        this.messages = new String[size];
        this.countOne = 0;
        this.countTwo = 0;
    }

    public void put(String message) {
        String no = String.format("%04d", messageNumber);
        messageNumber++;
        if (no.equals("9999")) {
            messageNumber = 0;
        }
        messages[countOne] = no + ") " + message;
        countOne = countOne + 1;
        countTwo = countTwo + 1;
        if (countOne >= size) {
            countOne = 0;
        }
    }

    public String[] getNewest(int numMessages) {

        //int counter = 0;
        String[] request = new String[0];
        if (numMessages < 0) {
            return null;
        }
        if (numMessages == 0) {
            String[] empty = new String[0];
            return empty;
        }
        if (countTwo < size) {
            if (numMessages > countTwo) {
                request = new String[countTwo];
                for (int i = 0; i < countTwo; i++) { //Fix for size error
                    request[i] = messages[i];
                }
                return request;
            } else {
                int x = countTwo - 1;
                request = new String[numMessages];
                for (int i = numMessages - 1; i >= 0; i--) {
                    request[i] = messages[x];
                    x--;
                }
                return request;
            }
        } else if (countTwo > size) {
            int index = (countTwo % size) - 1;
            if (numMessages > size) {
                request = new String[size];
            } else {
                request = new String[numMessages];
            }
            int j = 0;
            for (int i = index; i >= 0; i--) {
                request[j] = messages[i];
                j++;
            }
            for (int i = size - 1; i > index; i--) {
                if ( j < request.length) {
                    request[j] = messages[i];
                    j++;
                }
            }
            String[] temp = new String[request.length];
            int k = 0;
            for (int i = request.length - 1; i >= 0; i--) {
                temp[k] = request[i];
                k++;
            }
            request = temp;
        }
        return request;
    }
}
