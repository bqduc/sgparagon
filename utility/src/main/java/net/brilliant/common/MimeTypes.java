/**
 * 
 */
package net.brilliant.common;

import java.util.HashMap;

/**
 * @author ducbq
 *
 *         Map file extensions to MIME types. Based on the Apache mime.types file. http://www.iana.org/assignments/media-types/
 * 
 */
public class MimeTypes {
	public static final String MIME_APPLICATION_ANDREW_INSET = "application/andrew-inset";
	public static final String MIME_APPLICATION_JSON = "application/json";
	public static final String MIME_APPLICATION_ZIP = "application/zip";
	public static final String MIME_APPLICATION_X_GZIP = "application/x-gzip";
	public static final String MIME_APPLICATION_TGZ = "application/tgz";
	public static final String MIME_APPLICATION_MSWORD = "application/msword";
	public static final String MIME_APPLICATION_POSTSCRIPT = "application/postscript";
	public static final String MIME_APPLICATION_PDF = "application/pdf";
	public static final String MIME_APPLICATION_JNLP = "application/jnlp";
	public static final String MIME_APPLICATION_MAC_BINHEX40 = "application/mac-binhex40";
	public static final String MIME_APPLICATION_MAC_COMPACTPRO = "application/mac-compactpro";
	public static final String MIME_APPLICATION_MATHML_XML = "application/mathml+xml";
	public static final String MIME_APPLICATION_OCTET_STREAM = "application/octet-stream";
	public static final String MIME_APPLICATION_ODA = "application/oda";
	public static final String MIME_APPLICATION_RDF_XML = "application/rdf+xml";
	public static final String MIME_APPLICATION_JAVA_ARCHIVE = "application/java-archive";
	public static final String MIME_APPLICATION_RDF_SMIL = "application/smil";
	public static final String MIME_APPLICATION_SRGS = "application/srgs";
	public static final String MIME_APPLICATION_SRGS_XML = "application/srgs+xml";
	public static final String MIME_APPLICATION_VND_MIF = "application/vnd.mif";
	public static final String MIME_APPLICATION_VND_MSEXCEL = "application/vnd.ms-excel";
	public static final String MIME_APPLICATION_VND_MSPOWERPOINT = "application/vnd.ms-powerpoint";
	public static final String MIME_APPLICATION_VND_RNREALMEDIA = "application/vnd.rn-realmedia";
	public static final String MIME_APPLICATION_X_BCPIO = "application/x-bcpio";
	public static final String MIME_APPLICATION_X_CDLINK = "application/x-cdlink";
	public static final String MIME_APPLICATION_X_CHESS_PGN = "application/x-chess-pgn";
	public static final String MIME_APPLICATION_X_CPIO = "application/x-cpio";
	public static final String MIME_APPLICATION_X_CSH = "application/x-csh";
	public static final String MIME_APPLICATION_X_DIRECTOR = "application/x-director";
	public static final String MIME_APPLICATION_X_DVI = "application/x-dvi";
	public static final String MIME_APPLICATION_X_FUTURESPLASH = "application/x-futuresplash";
	public static final String MIME_APPLICATION_X_GTAR = "application/x-gtar";
	public static final String MIME_APPLICATION_X_HDF = "application/x-hdf";
	public static final String MIME_APPLICATION_X_JAVASCRIPT = "application/x-javascript";
	public static final String MIME_APPLICATION_X_KOAN = "application/x-koan";
	public static final String MIME_APPLICATION_X_LATEX = "application/x-latex";
	public static final String MIME_APPLICATION_X_NETCDF = "application/x-netcdf";
	public static final String MIME_APPLICATION_X_OGG = "application/x-ogg";
	public static final String MIME_APPLICATION_X_SH = "application/x-sh";
	public static final String MIME_APPLICATION_X_SHAR = "application/x-shar";
	public static final String MIME_APPLICATION_X_SHOCKWAVE_FLASH = "application/x-shockwave-flash";
	public static final String MIME_APPLICATION_X_STUFFIT = "application/x-stuffit";
	public static final String MIME_APPLICATION_X_SV4CPIO = "application/x-sv4cpio";
	public static final String MIME_APPLICATION_X_SV4CRC = "application/x-sv4crc";
	public static final String MIME_APPLICATION_X_TAR = "application/x-tar";
	public static final String MIME_APPLICATION_X_RAR_COMPRESSED = "application/x-rar-compressed";
	public static final String MIME_APPLICATION_X_TCL = "application/x-tcl";
	public static final String MIME_APPLICATION_X_TEX = "application/x-tex";
	public static final String MIME_APPLICATION_X_TEXINFO = "application/x-texinfo";
	public static final String MIME_APPLICATION_X_TROFF = "application/x-troff";
	public static final String MIME_APPLICATION_X_TROFF_MAN = "application/x-troff-man";
	public static final String MIME_APPLICATION_X_TROFF_ME = "application/x-troff-me";
	public static final String MIME_APPLICATION_X_TROFF_MS = "application/x-troff-ms";
	public static final String MIME_APPLICATION_X_USTAR = "application/x-ustar";
	public static final String MIME_APPLICATION_X_WAIS_SOURCE = "application/x-wais-source";
	public static final String MIME_APPLICATION_VND_MOZZILLA_XUL_XML = "application/vnd.mozilla.xul+xml";
	public static final String MIME_APPLICATION_XHTML_XML = "application/xhtml+xml";
	public static final String MIME_APPLICATION_XSLT_XML = "application/xslt+xml";
	public static final String MIME_APPLICATION_XML = "application/xml";
	public static final String MIME_APPLICATION_XML_DTD = "application/xml-dtd";
	public static final String MIME_IMAGE_BMP = "image/bmp";
	public static final String MIME_IMAGE_CGM = "image/cgm";
	public static final String MIME_IMAGE_GIF = "image/gif";
	public static final String MIME_IMAGE_IEF = "image/ief";
	public static final String MIME_IMAGE_JPEG = "image/jpeg";
	public static final String MIME_IMAGE_TIFF = "image/tiff";
	public static final String MIME_IMAGE_PNG = "image/png";
	public static final String MIME_IMAGE_SVG_XML = "image/svg+xml";
	public static final String MIME_IMAGE_VND_DJVU = "image/vnd.djvu";
	public static final String MIME_IMAGE_WAP_WBMP = "image/vnd.wap.wbmp";
	public static final String MIME_IMAGE_X_CMU_RASTER = "image/x-cmu-raster";
	public static final String MIME_IMAGE_X_ICON = "image/x-icon";
	public static final String MIME_IMAGE_X_PORTABLE_ANYMAP = "image/x-portable-anymap";
	public static final String MIME_IMAGE_X_PORTABLE_BITMAP = "image/x-portable-bitmap";
	public static final String MIME_IMAGE_X_PORTABLE_GRAYMAP = "image/x-portable-graymap";
	public static final String MIME_IMAGE_X_PORTABLE_PIXMAP = "image/x-portable-pixmap";
	public static final String MIME_IMAGE_X_RGB = "image/x-rgb";
	public static final String MIME_AUDIO_BASIC = "audio/basic";
	public static final String MIME_AUDIO_MIDI = "audio/midi";
	public static final String MIME_AUDIO_MPEG = "audio/mpeg";
	public static final String MIME_AUDIO_X_AIFF = "audio/x-aiff";
	public static final String MIME_AUDIO_X_MPEGURL = "audio/x-mpegurl";
	public static final String MIME_AUDIO_X_PN_REALAUDIO = "audio/x-pn-realaudio";
	public static final String MIME_AUDIO_X_WAV = "audio/x-wav";
	public static final String MIME_CHEMICAL_X_PDB = "chemical/x-pdb";
	public static final String MIME_CHEMICAL_X_XYZ = "chemical/x-xyz";
	public static final String MIME_MODEL_IGES = "model/iges";
	public static final String MIME_MODEL_MESH = "model/mesh";
	public static final String MIME_MODEL_VRLM = "model/vrml";
	public static final String MIME_TEXT_PLAIN = "text/plain";
	public static final String MIME_TEXT_RICHTEXT = "text/richtext";
	public static final String MIME_TEXT_RTF = "text/rtf";
	public static final String MIME_TEXT_HTML = "text/html";
	public static final String MIME_TEXT_CALENDAR = "text/calendar";
	public static final String MIME_TEXT_CSS = "text/css";
	public static final String MIME_TEXT_SGML = "text/sgml";
	public static final String MIME_TEXT_TAB_SEPARATED_VALUES = "text/tab-separated-values";
	public static final String MIME_TEXT_VND_WAP_XML = "text/vnd.wap.wml";
	public static final String MIME_TEXT_VND_WAP_WMLSCRIPT = "text/vnd.wap.wmlscript";
	public static final String MIME_TEXT_X_SETEXT = "text/x-setext";
	public static final String MIME_TEXT_X_COMPONENT = "text/x-component";
	public static final String MIME_VIDEO_QUICKTIME = "video/quicktime";
	public static final String MIME_VIDEO_MPEG = "video/mpeg";
	public static final String MIME_VIDEO_VND_MPEGURL = "video/vnd.mpegurl";
	public static final String MIME_VIDEO_X_MSVIDEO = "video/x-msvideo";
	public static final String MIME_VIDEO_X_MS_WMV = "video/x-ms-wmv";
	public static final String MIME_VIDEO_X_SGI_MOVIE = "video/x-sgi-movie";
	public static final String MIME_X_CONFERENCE_X_COOLTALK = "x-conference/x-cooltalk";

	private static HashMap<String, String> mimeTypeMapping;

	static {
		mimeTypeMapping = new HashMap<String, String>(200) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 6284759033239683056L;

			private void doPut(String key, String value) {
				if (put(key, value) != null) {
					throw new IllegalArgumentException("Duplicated extension: " + key);
				}
			}

			{
				doPut("xul", MIME_APPLICATION_VND_MOZZILLA_XUL_XML);
				doPut("json", MIME_APPLICATION_JSON);
				doPut("ice", MIME_X_CONFERENCE_X_COOLTALK);
				doPut("movie", MIME_VIDEO_X_SGI_MOVIE);
				doPut("avi", MIME_VIDEO_X_MSVIDEO);
				doPut("wmv", MIME_VIDEO_X_MS_WMV);
				doPut("m4u", MIME_VIDEO_VND_MPEGURL);
				doPut("mxu", MIME_VIDEO_VND_MPEGURL);
				doPut("htc", MIME_TEXT_X_COMPONENT);
				doPut("etx", MIME_TEXT_X_SETEXT);
				doPut("wmls", MIME_TEXT_VND_WAP_WMLSCRIPT);
				doPut("wml", MIME_TEXT_VND_WAP_XML);
				doPut("tsv", MIME_TEXT_TAB_SEPARATED_VALUES);
				doPut("sgm", MIME_TEXT_SGML);
				doPut("sgml", MIME_TEXT_SGML);
				doPut("css", MIME_TEXT_CSS);
				doPut("ifb", MIME_TEXT_CALENDAR);
				doPut("ics", MIME_TEXT_CALENDAR);
				doPut("wrl", MIME_MODEL_VRLM);
				doPut("vrlm", MIME_MODEL_VRLM);
				doPut("silo", MIME_MODEL_MESH);
				doPut("mesh", MIME_MODEL_MESH);
				doPut("msh", MIME_MODEL_MESH);
				doPut("iges", MIME_MODEL_IGES);
				doPut("igs", MIME_MODEL_IGES);
				doPut("rgb", MIME_IMAGE_X_RGB);
				doPut("ppm", MIME_IMAGE_X_PORTABLE_PIXMAP);
				doPut("pgm", MIME_IMAGE_X_PORTABLE_GRAYMAP);
				doPut("pbm", MIME_IMAGE_X_PORTABLE_BITMAP);
				doPut("pnm", MIME_IMAGE_X_PORTABLE_ANYMAP);
				doPut("ico", MIME_IMAGE_X_ICON);
				doPut("ras", MIME_IMAGE_X_CMU_RASTER);
				doPut("wbmp", MIME_IMAGE_WAP_WBMP);
				doPut("djv", MIME_IMAGE_VND_DJVU);
				doPut("djvu", MIME_IMAGE_VND_DJVU);
				doPut("svg", MIME_IMAGE_SVG_XML);
				doPut("ief", MIME_IMAGE_IEF);
				doPut("cgm", MIME_IMAGE_CGM);
				doPut("bmp", MIME_IMAGE_BMP);
				doPut("xyz", MIME_CHEMICAL_X_XYZ);
				doPut("pdb", MIME_CHEMICAL_X_PDB);
				doPut("ra", MIME_AUDIO_X_PN_REALAUDIO);
				doPut("ram", MIME_AUDIO_X_PN_REALAUDIO);
				doPut("m3u", MIME_AUDIO_X_MPEGURL);
				doPut("aifc", MIME_AUDIO_X_AIFF);
				doPut("aif", MIME_AUDIO_X_AIFF);
				doPut("aiff", MIME_AUDIO_X_AIFF);
				doPut("mp3", MIME_AUDIO_MPEG);
				doPut("mp2", MIME_AUDIO_MPEG);
				doPut("mp1", MIME_AUDIO_MPEG);
				doPut("mpga", MIME_AUDIO_MPEG);
				doPut("kar", MIME_AUDIO_MIDI);
				doPut("mid", MIME_AUDIO_MIDI);
				doPut("midi", MIME_AUDIO_MIDI);
				doPut("dtd", MIME_APPLICATION_XML_DTD);
				doPut("xsl", MIME_APPLICATION_XML);
				doPut("xml", MIME_APPLICATION_XML);
				doPut("xslt", MIME_APPLICATION_XSLT_XML);
				doPut("xht", MIME_APPLICATION_XHTML_XML);
				doPut("xhtml", MIME_APPLICATION_XHTML_XML);
				doPut("src", MIME_APPLICATION_X_WAIS_SOURCE);
				doPut("ustar", MIME_APPLICATION_X_USTAR);
				doPut("ms", MIME_APPLICATION_X_TROFF_MS);
				doPut("me", MIME_APPLICATION_X_TROFF_ME);
				doPut("man", MIME_APPLICATION_X_TROFF_MAN);
				doPut("roff", MIME_APPLICATION_X_TROFF);
				doPut("tr", MIME_APPLICATION_X_TROFF);
				doPut("t", MIME_APPLICATION_X_TROFF);
				doPut("texi", MIME_APPLICATION_X_TEXINFO);
				doPut("texinfo", MIME_APPLICATION_X_TEXINFO);
				doPut("tex", MIME_APPLICATION_X_TEX);
				doPut("tcl", MIME_APPLICATION_X_TCL);
				doPut("sv4crc", MIME_APPLICATION_X_SV4CRC);
				doPut("sv4cpio", MIME_APPLICATION_X_SV4CPIO);
				doPut("sit", MIME_APPLICATION_X_STUFFIT);
				doPut("swf", MIME_APPLICATION_X_SHOCKWAVE_FLASH);
				doPut("shar", MIME_APPLICATION_X_SHAR);
				doPut("sh", MIME_APPLICATION_X_SH);
				doPut("cdf", MIME_APPLICATION_X_NETCDF);
				doPut("nc", MIME_APPLICATION_X_NETCDF);
				doPut("latex", MIME_APPLICATION_X_LATEX);
				doPut("skm", MIME_APPLICATION_X_KOAN);
				doPut("skt", MIME_APPLICATION_X_KOAN);
				doPut("skd", MIME_APPLICATION_X_KOAN);
				doPut("skp", MIME_APPLICATION_X_KOAN);
				doPut("js", MIME_APPLICATION_X_JAVASCRIPT);
				doPut("hdf", MIME_APPLICATION_X_HDF);
				doPut("gtar", MIME_APPLICATION_X_GTAR);
				doPut("spl", MIME_APPLICATION_X_FUTURESPLASH);
				doPut("dvi", MIME_APPLICATION_X_DVI);
				doPut("dxr", MIME_APPLICATION_X_DIRECTOR);
				doPut("dir", MIME_APPLICATION_X_DIRECTOR);
				doPut("dcr", MIME_APPLICATION_X_DIRECTOR);
				doPut("csh", MIME_APPLICATION_X_CSH);
				doPut("cpio", MIME_APPLICATION_X_CPIO);
				doPut("pgn", MIME_APPLICATION_X_CHESS_PGN);
				doPut("vcd", MIME_APPLICATION_X_CDLINK);
				doPut("bcpio", MIME_APPLICATION_X_BCPIO);
				doPut("rm", MIME_APPLICATION_VND_RNREALMEDIA);
				doPut("ppt", MIME_APPLICATION_VND_MSPOWERPOINT);
				doPut("mif", MIME_APPLICATION_VND_MIF);
				doPut("grxml", MIME_APPLICATION_SRGS_XML);
				doPut("gram", MIME_APPLICATION_SRGS);
				doPut("smil", MIME_APPLICATION_RDF_SMIL);
				doPut("smi", MIME_APPLICATION_RDF_SMIL);
				doPut("rdf", MIME_APPLICATION_RDF_XML);
				doPut("ogg", MIME_APPLICATION_X_OGG);
				doPut("oda", MIME_APPLICATION_ODA);
				doPut("dmg", MIME_APPLICATION_OCTET_STREAM);
				doPut("lzh", MIME_APPLICATION_OCTET_STREAM);
				doPut("so", MIME_APPLICATION_OCTET_STREAM);
				doPut("lha", MIME_APPLICATION_OCTET_STREAM);
				doPut("dms", MIME_APPLICATION_OCTET_STREAM);
				doPut("bin", MIME_APPLICATION_OCTET_STREAM);
				doPut("mathml", MIME_APPLICATION_MATHML_XML);
				doPut("cpt", MIME_APPLICATION_MAC_COMPACTPRO);
				doPut("hqx", MIME_APPLICATION_MAC_BINHEX40);
				doPut("jnlp", MIME_APPLICATION_JNLP);
				doPut("ez", MIME_APPLICATION_ANDREW_INSET);
				doPut("txt", MIME_TEXT_PLAIN);
				doPut("ini", MIME_TEXT_PLAIN);
				doPut("c", MIME_TEXT_PLAIN);
				doPut("h", MIME_TEXT_PLAIN);
				doPut("cpp", MIME_TEXT_PLAIN);
				doPut("cxx", MIME_TEXT_PLAIN);
				doPut("cc", MIME_TEXT_PLAIN);
				doPut("chh", MIME_TEXT_PLAIN);
				doPut("java", MIME_TEXT_PLAIN);
				doPut("csv", MIME_TEXT_PLAIN);
				doPut("bat", MIME_TEXT_PLAIN);
				doPut("cmd", MIME_TEXT_PLAIN);
				doPut("asc", MIME_TEXT_PLAIN);
				doPut("rtf", MIME_TEXT_RTF);
				doPut("rtx", MIME_TEXT_RICHTEXT);
				doPut("html", MIME_TEXT_HTML);
				doPut("htm", MIME_TEXT_HTML);
				doPut("zip", MIME_APPLICATION_ZIP);
				doPut("rar", MIME_APPLICATION_X_RAR_COMPRESSED);
				doPut("gzip", MIME_APPLICATION_X_GZIP);
				doPut("gz", MIME_APPLICATION_X_GZIP);
				doPut("tgz", MIME_APPLICATION_TGZ);
				doPut("tar", MIME_APPLICATION_X_TAR);
				doPut("gif", MIME_IMAGE_GIF);
				doPut("jpeg", MIME_IMAGE_JPEG);
				doPut("jpg", MIME_IMAGE_JPEG);
				doPut("jpe", MIME_IMAGE_JPEG);
				doPut("tiff", MIME_IMAGE_TIFF);
				doPut("tif", MIME_IMAGE_TIFF);
				doPut("png", MIME_IMAGE_PNG);
				doPut("au", MIME_AUDIO_BASIC);
				doPut("snd", MIME_AUDIO_BASIC);
				doPut("wav", MIME_AUDIO_X_WAV);
				doPut("mov", MIME_VIDEO_QUICKTIME);
				doPut("qt", MIME_VIDEO_QUICKTIME);
				doPut("mpeg", MIME_VIDEO_MPEG);
				doPut("mpg", MIME_VIDEO_MPEG);
				doPut("mpe", MIME_VIDEO_MPEG);
				doPut("abs", MIME_VIDEO_MPEG);
				doPut("doc", MIME_APPLICATION_MSWORD);
				doPut("docx", MIME_APPLICATION_MSWORD);
				doPut("xls", MIME_APPLICATION_VND_MSEXCEL);
				doPut("xlsx", MIME_APPLICATION_VND_MSEXCEL);
				doPut("eps", MIME_APPLICATION_POSTSCRIPT);
				doPut("ai", MIME_APPLICATION_POSTSCRIPT);
				doPut("ps", MIME_APPLICATION_POSTSCRIPT);
				doPut("pdf", MIME_APPLICATION_PDF);
				doPut("exe", MIME_APPLICATION_OCTET_STREAM);
				doPut("dll", MIME_APPLICATION_OCTET_STREAM);
				doPut("class", MIME_APPLICATION_OCTET_STREAM);
				doPut("jar", MIME_APPLICATION_JAVA_ARCHIVE);
			}
		};
	}

	public static void main(String[] args) {
		System.out.println(mimeTypeMapping.size());
	}

	/**
	 * Registers MIME type for provided extension. Existing extension type will be overriden.
	 */
	public static void registerMimeType(String ext, String mimeType) {
		mimeTypeMapping.put(ext, mimeType);
	}

	/**
	 * Returns the corresponding MIME type to the given extension. If no MIME type was found it returns 'application/octet-stream' type.
	 */
	public static String getMimeType(String ext) {
		String mimeType = lookupMimeType(ext);
		if (mimeType == null) {
			mimeType = MIME_APPLICATION_OCTET_STREAM;
		}
		return mimeType;
	}

	/**
	 * Simply returns MIME type or <code>null</code> if no type is found.
	 */
	public static String lookupMimeType(String ext) {
		return mimeTypeMapping.get(ext.toLowerCase());
	}
}
