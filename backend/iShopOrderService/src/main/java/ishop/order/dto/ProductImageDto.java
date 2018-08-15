package ishop.order.dto;

public class ProductImageDto {

	private long id;
	private String fileName;
	 private String fileUri;
	 private String fileType;
	private long size;

	public ProductImageDto() {
		super();
	}

	public ProductImageDto(long id, String fileName, String fileUri, String fileType, long size) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileUri = fileUri;
		this.fileType = fileType;
		this.size = size;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileUri() {
		return fileUri;
	}

	public void setFileUri(String fileUri) {
		this.fileUri = fileUri;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}
}
