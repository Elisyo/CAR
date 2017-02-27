package tp_fileServer;

import java.io.File;
import java.net.ProtocolException;
import java.util.List;

public interface FileProtocolInterface {
	void writeRequestHeader(String name) throws ProtocolException;
	void writeResponseHeader(int code) throws ProtocolException;
	String readRequestHeader() throws ProtocolException;
	int readResponseHeader() throws ProtocolException;
	void writeParString(String value) throws ProtocolException;
	String readParString() throws ProtocolException;
	void writeParFile(File file) throws ProtocolException;
	File readParFile() throws ProtocolException;
	void writeParList(List<String> tagList) throws ProtocolException;
	List<String> readParList() throws ProtocolException;
}
