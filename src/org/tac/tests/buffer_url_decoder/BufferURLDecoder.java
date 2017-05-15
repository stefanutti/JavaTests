package org.tac.tests.buffer_url_decoder;

import java.net.URLDecoder;

class BufferURLDecoder {

	public static void main(String[] args) {
		System.out.println("Starting BufferURLDecoder...");
		System.out.println("");

		try {
			System.out.println("" + URLDecoder.decode("SWEExtData=%3C%3Fxml+version%3D%221.0%22+encoding%3D%22UTF-8%22%3F%3E%0A%3C%3FSiebel-Property-Set+EscapeNames%3D%22false%22%3F%3E%0A%3CSiebelMessage+ErrorDescription%3D%22%22+IntObjectFormat%3D%22Siebel+Hierarchical%22+IntObjectName%3D%22CRMCIONotificheArcheaOnLine%22+MessageId%3D%22%22+MessageType%3D%22Integration+Object%22+OperationCode%3D%22ARCHEA100%22+OperationType%3D%22Request%22+ReturnCode%3D%220%22+Service%3D%22documentoAcquisito%22+System%3D%22ARCHEA%22+Tid%3D%220A06413C42A86A4D5AF82633%22+xmlns%3Axsi%3D%22http%3A%2F%2Fwww.w3.org%2F2001%2FXMLSchema-instance%22+xsi%3AnoNamespaceSchemaLocation%3D%22.%5CCRMCIONotificheArcheaOnLine.xsd%22%3E+%3CListOfCrmcionotifichearcheaonline%3E%3CCrmcbcdocinclionline%3E%3CCRMCAccountName%3ECNTGLN55A63B828Y%3C%2FCRMCAccountName%3E%3CCRMCDocTypeCod%3E1%3C%2FCRMCDocTypeCod%3E%3CCRMCDocNum%3EAJ4794312%3C%2FCRMCDocNum%3E%3CCRMCDocDate%3E06%2F29%2F2004%3C%2FCRMCDocDate%3E%3CCRMCCodActvX%3E07%3C%2FCRMCCodActvX%3E%3CCRMCLinkDoc%3EIM%3DV10-331%2F39_n7yq+Pagina+1%40IM%3DV10-331%2F39_ndrs+Pagina+2%3C%2FCRMCLinkDoc%3E%3C%2FCrmcbcdocinclionline%3E%3C%2FListOfCrmcionotifichearcheaonline%3E%3C%2FSiebelMessage%3E","UTF-8"));
		} catch (Exception exc) {
			System.out.println("Exception caught");
			exc.printStackTrace();
		}

		System.out.println("");
		System.out.println("Ending BufferURLDecoder");
	}
}
