<?xml version="1.0" encoding="UTF-8"?><project xmlns="http://grogra.de/registry" graph="graph.xml">
 <import plugin="de.grogra.rgg" version="1.6"/>
 <import plugin="de.grogra.pf" version="1.6"/>
 <import plugin="de.grogra.imp" version="1.6"/>
 <import plugin="de.grogra.math" version="1.6"/>
 <import plugin="de.grogra.imp3d" version="1.6"/>
 <registry>
  <ref name="project">
   <ref name="objects">
    <ref name="files">
     <de.grogra.pf.ui.registry.SourceFile mimeType="text/x-grogra-rgg" name="pfs:main.rgg"/>
     <de.grogra.pf.ui.registry.SourceFile mimeType="text/x-java" name="/var/model/src/fspm/utils/FileReader.java"/>
     <de.grogra.pf.ui.registry.SourceFile mimeType="text/x-grogra-xl" name="/var/model/src/fspm/models/organs/GenericOrgan.xl"/>
     <de.grogra.pf.ui.registry.SourceFile mimeType="text/x-java" name="/var/model/src/fspm/functions/IFunction.java"/>
     <de.grogra.pf.ui.registry.SourceFile mimeType="text/x-java" name="/var/model/src/fspm/functions/FunctionCollector.java"/>
     <de.grogra.pf.ui.registry.SourceFile mimeType="text/x-grogra-rgg" name="/var/model/src/fspm/utils/Utils.rgg"/>
     <de.grogra.pf.ui.registry.SourceFile mimeType="text/x-java" name="/var/model/src/fspm/utils/ScenarioConfigDeserializer.java"/>
     <de.grogra.pf.ui.registry.SourceFile mimeType="text/x-java" name="/var/model/src/fspm/utils/TreatmentConfigDeserializer.java"/>
     <de.grogra.pf.ui.registry.SourceFile mimeType="text/x-java" name="/var/model/src/fspm/models/scenario/Scenario.java"/>
     <de.grogra.pf.ui.registry.SourceFile mimeType="text/x-java" name="/var/model/src/fspm/models/scenario/Treatment.java"/>
     <de.grogra.pf.ui.registry.SourceFile mimeType="text/x-java" name="/var/model/src/fspm/utils/OrganConfigDeserializer.java"/>
     <de.grogra.pf.ui.registry.SourceFile mimeType="text/x-java" name="/var/model/src/fspm/config/Config.java"/>
     <de.grogra.pf.ui.registry.SourceFile mimeType="text/x-java" name="/var/model/src/fspm/exceptions/CategoryNotFoundException.java"/>
     <de.grogra.pf.ui.registry.SourceFile mimeType="text/x-java" name="/var/model/src/fspm/exceptions/UniqueKeyException.java"/>
     <de.grogra.pf.ui.registry.SourceFile mimeType="text/x-java" name="/var/model/src/fspm/config/ModelConfig.java"/>
     <de.grogra.pf.ui.registry.SourceFile mimeType="text/x-java" name="/var/model/src/fspm/config/OrganConfig.java"/>
     <de.grogra.pf.ui.registry.SourceFile mimeType="text/x-java" name="/var/model/src/fspm/config/ParamContainer.java"/>
     <de.grogra.pf.ui.registry.SourceFile mimeType="text/x-java" name="/var/model/src/fspm/utils/DataStore.java"/>
     <de.grogra.pf.ui.registry.SourceFile mimeType="text/x-java" name="/var/model/src/fspm/exceptions/ParamNotFoundException.java"/>
     <de.grogra.pf.ui.registry.SourceFile mimeType="text/x-java" name="/var/model/src/fspm/utils/ParamConfigDeserializer.java"/>
    </ref>
    <ref name="meta">
     <de.grogra.pf.registry.NodeReference name="main" ref="15283"/>
     <de.grogra.pf.registry.NodeReference name="Utils" ref="15284"/>
    </ref>
   </ref>
  </ref>
  <ref name="workbench">
   <ref name="state">
    <de.grogra.pf.ui.registry.Layout name="layout">
     <de.grogra.pf.ui.registry.MainWindow>
      <de.grogra.pf.ui.registry.Split location="0.49910715">
       <de.grogra.pf.ui.registry.Split location="0.51846963" orientation="0">
        <de.grogra.pf.ui.registry.Split orientation="0">
         <de.grogra.pf.registry.Link source="/ui/panels/rgg/toolbar"/>
         <de.grogra.pf.ui.registry.PanelFactory source="/ui/panels/3d/defaultview">
          <de.grogra.pf.registry.Option name="panelId" type="java.lang.String" value="/ui/panels/3d/defaultview"/>
          <de.grogra.pf.registry.Option name="panelTitle" type="java.lang.String" value="View"/>
          <de.grogra.pf.registry.Option name="view" type="de.grogra.imp3d.View3D" value="graphDescriptor=[de.grogra.imp.ProjectGraphDescriptor]visibleScales={true true true true true true true true true true true true true true true}visibleLayers={true true true true true true true true true true true true true true true true}epsilon=1.0E-6 visualEpsilon=0.01 magnitude=1.0 camera=(minZ=0.1 maxZ=2000.0 projection=[de.grogra.imp3d.PerspectiveProjection aspect=1.0 fieldOfView=1.0471976]transformation=(0.0026110166485736885 0.9999965912902207 0.0 0.0 -0.18924923304053543 4.941345825598123E-4 0.9819289605794219 0.0 0.9819256134685717 -0.0025638328637891117 0.18924987813844601 -40.82507045481592 0.0 0.0 0.0 1.0))navigator=null"/>
         </de.grogra.pf.ui.registry.PanelFactory>
        </de.grogra.pf.ui.registry.Split>
        <de.grogra.pf.ui.registry.Split orientation="0">
         <de.grogra.pf.ui.registry.Tab selectedIndex="0">
          <de.grogra.pf.registry.Link source="/ui/panels/fileexplorer"/>
          <de.grogra.pf.registry.Link source="/ui/panels/objects/meta"/>
         </de.grogra.pf.ui.registry.Tab>
         <de.grogra.pf.registry.Link source="/ui/panels/statusbar"/>
        </de.grogra.pf.ui.registry.Split>
       </de.grogra.pf.ui.registry.Split>
       <de.grogra.pf.ui.registry.Split location="0.49604222" orientation="0">
        <de.grogra.pf.ui.registry.Tab selectedIndex="0">
         <de.grogra.pf.ui.registry.PanelFactory source="/ui/panels/texteditor">
          <de.grogra.pf.registry.Option name="documents" type="java.lang.String" value="&quot;\&quot;pfs:main.rgg\&quot;,\&quot;pfs:Untitled-1\&quot;&quot;"/>
          <de.grogra.pf.registry.Option name="panelId" type="java.lang.String" value="/ui/panels/texteditor"/>
          <de.grogra.pf.registry.Option name="panelTitle" type="java.lang.String" value="jEdit - main.rgg"/>
          <de.grogra.pf.registry.Option name="selected" type="java.lang.String" value="pfs:main.rgg"/>
         </de.grogra.pf.ui.registry.PanelFactory>
         <de.grogra.pf.registry.Link source="/ui/panels/attributeeditor"/>
        </de.grogra.pf.ui.registry.Tab>
        <de.grogra.pf.ui.registry.Tab selectedIndex="1">
         <de.grogra.pf.registry.Link source="/ui/panels/log"/>
         <de.grogra.pf.registry.Link source="/ui/panels/rgg/console"/>
        </de.grogra.pf.ui.registry.Tab>
       </de.grogra.pf.ui.registry.Split>
      </de.grogra.pf.ui.registry.Split>
     </de.grogra.pf.ui.registry.MainWindow>
    </de.grogra.pf.ui.registry.Layout>
   </ref>
  </ref>
 </registry>
</project>
