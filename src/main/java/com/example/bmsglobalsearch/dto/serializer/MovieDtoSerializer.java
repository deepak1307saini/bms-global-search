package com.example.bmsglobalsearch.dto.serializer;

import com.example.bmsglobalsearch.dto.MovieResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.util.List;

public class MovieDtoSerializer implements Serializer<List<MovieResponseDto>> {
	private final ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public byte[] serialize(String s, List<MovieResponseDto> movieResponseDtoS) {
		try {
			if(movieResponseDtoS == null) return null;
			return objectMapper.writeValueAsBytes(movieResponseDtoS);
		} catch (JsonProcessingException e) {
			throw new SerializationException("Error while serializing Movie " + e);
		}
	}
}
