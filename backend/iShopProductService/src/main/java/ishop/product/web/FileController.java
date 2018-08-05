package ishop.product.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import ishop.product.service.FileStorageService;
import ishop.product.service.FileUploadService;

@RestController
public class FileController {

	private static final Logger logger = LoggerFactory.getLogger(FileController.class);

	@Autowired
	FileUploadService fileUploadService;
	@Autowired
	FileStorageService fileStorageService;

	@PostMapping("/uploadFile/{productId}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable String productId) {
		return fileUploadService.uploadImage(file, productId);
	}

	@PostMapping("/uploadMultipleFiles/{productId}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files,
			@PathVariable String productId) {
		return fileUploadService.uploadImages(files, productId);
	}

	@GetMapping("/productImage/{fileName:.+}")
	public ResponseEntity<Resource> productImage(@PathVariable String fileName, HttpServletRequest request) {
		// Load file as Resource
		Resource resource = fileStorageService.loadFileAsResource(fileName);

		// Try to determine file's content type
		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (IOException ex) {
			logger.info("Could not determine file type.");
		}

		// Fallback to the default content type if type could not be determined
		if (contentType == null) {
			contentType = "application/octet-stream";
		}

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				// .header(HttpHeaders. "attachment; filename=\"" + resource.getFilename() +
				// "\"")
				.body(resource);
	}

}
