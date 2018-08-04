<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns="http://capabilities.nat.bt.com/xsd/MARTCapability/2008/17/03"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:S429="http://capabilities.nat.bt.com/xsd/MARTCapability/2008/17/03/NonCCM"
	xmlns:header="http://wsi.nat.bt.com/2005/06/StandardHeader/"
	xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://capabilities.nat.bt.com/xsd/MARTCapability/2008/17/03 C:\DOCUME~1\sk0024028\Desktop\MARTCapability\Interface_All\WSDLandXSD\MARTCapability.20081703.xsd">
	<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"
		omit-xml-declaration="yes" />

	<xsl:template match="/">
		<root>
			<xsl:apply-templates select="doProcessRequest/process" />
		</root>
	</xsl:template>

	<xsl:template match="doProcessRequest/process">
		<!--  <xsl:variable name="reqId" select="S429:requestId" />-->
		<reqId>
			<xsl:value-of select="S429:requestId" />
		</reqId>
		<xsl:variable name="failPolicy" select="S429:failPolicy" />
		<xsl:variable name="order" select="S429:order" />
		<xsl:apply-templates select="S429:templateList" />
		<xsl:for-each select="S429:operationSet">
			<xsl:variable name="oprSetLabel"
				select="S429:operationSetLabel" />
			<xsl:variable name="policy" select="S429:failPolicy" />
			<xsl:variable name="ord" select="S429:order" />
			<ord>
				<xsl:value-of select="$ord" />
			</ord>
			<xsl:for-each select="S429:operation">
				<xsl:variable name="operationLBL"
					select="S429:operationLabel" />
				<xsl:variable name="failPoc" select="S429:failPolicy" />
				<xsl:variable name="result" select="S429:result" />
				<xsl:variable name="errReason"
					select="S429:errorReason" />
				<err>
					<xsl:value-of select="$errReason" />
				</err>
				<xsl:variable name="dataReq"
					select="S429:isResultDataRequested" />
				<xsl:variable name="templateName"
					select="S429:templateName" />
				<xsl:variable name="operationData"
					select="S429:operationData" />
				<xsl:variable name="oprResult"
					select="S429:operationResultData" />
			</xsl:for-each>
		</xsl:for-each>
	</xsl:template>

	<xsl:template match="S429:templateList">
		<xsl:for-each select="S429:template">
			<xsl:variable name="name" select="S429:name" />
			<xsl:for-each select="S429:definition">
				<xsl:variable name="operationLBL"
					select="S429:operationLabel" />
				<operationLBL>
					<xsl:value-of select="$operationLBL" />
				</operationLBL>
				<xsl:variable name="failPoc" select="S429:failPolicy" />
				<xsl:variable name="result" select="S429:result" />
				<xsl:variable name="errReason"
					select="S429:errorReason" />
				<xsl:variable name="dataReq"
					select="S429:isResultDataRequested" />
				<xsl:variable name="templateName"
					select="S429:templateName" />
				<xsl:variable name="operationData"
					select="S429:operationData" />
				<xsl:variable name="oprResult"
					select="S429:operationResultData" />
			</xsl:for-each>
		</xsl:for-each>
	</xsl:template>

</xsl:stylesheet>