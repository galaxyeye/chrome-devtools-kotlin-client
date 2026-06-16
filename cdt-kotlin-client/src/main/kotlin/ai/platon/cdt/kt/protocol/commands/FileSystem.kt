@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.commands

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.ParamName
import ai.platon.cdt.kt.protocol.support.annotations.Returns
import ai.platon.cdt.kt.protocol.types.filesystem.BucketFileSystemLocator
import ai.platon.cdt.kt.protocol.types.filesystem.Directory

@Experimental
interface FileSystem {
  /**
   * @param bucketFileSystemLocator
   */
  @Returns("directory")
  suspend fun getDirectory(@ParamName("bucketFileSystemLocator") bucketFileSystemLocator: BucketFileSystemLocator): Directory
}
