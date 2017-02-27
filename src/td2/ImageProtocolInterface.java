package td2;

import java.awt.Image;
import java.net.ProtocolException;
import java.util.List;

public interface ImageProtocolInterface {

	void writeRequestHeader(String name) throws ProtocolException;
	void writeResponseHeader(int code) throws ProtocolException;
	String readRequestHeader() throws ProtocolException;
	int readResponseHeader() throws ProtocolException;
	void writeParString(String value) throws ProtocolException;
	String readParString() throws ProtocolException;
	void writeParImage(Image img) throws ProtocolException;
	Image readParImage() throws ProtocolException;
	void writeParList(List<String> tagList) throws ProtocolException;
	List<String> readParList() throws ProtocolException;
}
