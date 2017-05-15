<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:processing-instruction name="PROVA">PROVA</xsl:processing-instruction>
	<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
	<xsl:attribute-set name="ibAttributes">
		<xsl:attribute name="REQUEST_TYPE">Query</xsl:attribute>
	</xsl:attribute-set>
	<xsl:template match="/SiebelMessage">
		<xsl:copy-of select="."/>
	</xsl:template>
</xsl:stylesheet>