<?xml version='1.0'?>

<!-- 

	Changed to support XSLT version 2.0
		
 -->
 
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">

    <xsl:output encoding="US-ASCII" standalone="no" omit-xml-declaration="no"/>

    <xsl:variable name="invoke">/econ/documents</xsl:variable>
    <xsl:variable name="invoke1">/econ</xsl:variable>

    <xsl:template match="/">

        <xsl:apply-templates select="document-list/groups"/>

        <xsl:if test="document-list/document">
            <TABLE  cellspacing="0" cellpadding="1" class="search">
                <TR class="color1">
                    <TD class="width5">
                    </TD>
                    <TD class="width2">
                        <br/><b><font >Document list<br/></font></b><br/>
                    </TD>
                </TR>
                <TR>
                    <TD colspan="2">
                        <TABLE cellspacing="0" cellpadding="6" class="search">

                            <xsl:apply-templates select="document-list/document">
                                <xsl:sort select="label"/>
                            </xsl:apply-templates>
                        </TABLE>
                    </TD>
                </TR>
            </TABLE>
        </xsl:if>
    </xsl:template>


    <xsl:template match="document">
        <TR>
            <TD colspan="5" style="padding-top:0px; padding-bottom:0px"></TD>
        </TR>
        
         <xsl:variable name="color">
            <xsl:if test="position() mod 2 = 0">color2</xsl:if>
            <xsl:if test="position() mod 2 = 1">color3</xsl:if>
        </xsl:variable>
        
        <TR valign="top" class="{$color}">
             <TD class="width8" >
               <a class="nolink" href="{$invoke}/viewDocument?name={@name}" target="_self" title="view"><img src="{$invoke1}/images/lente.gif" border="0"/></a>
               <xsl:text>&#160;&#160;&#160;&#160;</xsl:text>
               <xsl:choose>
						<xsl:when test="permission = 'RW'" >
							<a class="nolink" href="{$invoke}/selectDocument?name={@name}" title="edit"><img src="{$invoke1}/images/edit.gif" border="0"/></a>
						</xsl:when>
						<xsl:when test="permission = 'LCK'">
							<img src="{$invoke1}/images/locking.gif" border="0" title="The document is locked by {permission/@user} at {permission/@host} [{permission/@address}]"/>
						</xsl:when>
					</xsl:choose>
               <xsl:text>&#160;&#160;&#160;&#160;</xsl:text>
               <xsl:if test="history = 'yes'"><a class="nolink" href="{$invoke1}/def/documents/document_history.jsp?name={@name}" title="history"><img src="{$invoke1}/images/history_view.gif" border="0"/></a>
               </xsl:if>
            </TD>	
            <TD>
                <b><nobr><xsl:value-of select="label"/></nobr></b>
                <xsl:if test="@isInError">
                	<nobr> <img src="{$invoke1}/images/warning.gif" border="0" alt="The document contains warnings"/></nobr>
                </xsl:if>
            </TD>
            <TD class="width7"></TD>
        	<TD><xsl:value-of select="description"/></TD>
            <TD class="width7"></TD>
           </TR>
    </xsl:template>

    <xsl:template match="groups">
        <TABLE cellpadding="0" cellspacing="0">
            <TR class="top">
                <TD><b>Group of documents:</b></TD>
                <TD class="width1"></TD>
                <TD>
                    <form name="groupForm" action="{$invoke}/selectGroup">
                        <select name="group" onchange="groupForm.submit()">
                            <xsl:apply-templates select="group[1]"/>
                            <xsl:apply-templates select="group[position() > 1]">
                                <xsl:sort select="@label"/>
                            </xsl:apply-templates>
                        </select>
                    </form>
                </TD>
                <TD class="width1"></TD>
                <TD class="left">
                	<a href="{$invoke}/checkWarnings" title="Check Warnings"><img src="{$invoke1}/images/check.gif" border="0"/></a>
                </TD>
            </TR>
        </TABLE>
    </xsl:template>

    <xsl:template match="group">
        <option value="{@name}"><xsl:value-of select="@label"/></option>
    </xsl:template>

</xsl:stylesheet>
