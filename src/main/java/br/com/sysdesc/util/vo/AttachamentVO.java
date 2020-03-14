package br.com.sysdesc.util.vo;

import lombok.Data;

@Data
public class AttachamentVO {

	private String name;

	private String mime;

	private byte[] file;
}