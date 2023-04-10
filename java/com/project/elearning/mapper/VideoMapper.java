package com.project.elearning.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.multipart.MultipartFile;

import com.project.elearning.pojo.Video;

public class VideoMapper implements RowMapper<Video> {

	@Override
	public Video mapRow(ResultSet rs, int rowNum) throws SQLException {
		Video videos=new Video();
		byte[] video=rs.getBytes("Video");
		String descriptionOfVideo=rs.getString("descriptionOfVideo");

			String base64Videos = Base64.getEncoder().encodeToString(video); 
	
			videos.setVideos(video);
			videos.setVideoPath(base64Videos);
			videos.setDescriptionOfVideo(descriptionOfVideo);
			return videos;
		
	}

}
