package td2;

import java.awt.Image;
import java.util.List;

public interface ImageStorageInterface {
	Image search(String name);
	void add(Image img, String name, List<String> tags);
	void delete(String name);
}
