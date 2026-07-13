@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.commands

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.ParamName
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Returns
import ai.platon.cdt.kt.serialization.protocol.types.filesystem.BucketFileSystemLocator
import ai.platon.cdt.kt.serialization.protocol.types.filesystem.Directory

@Experimental
interface FileSystem {
  /**
   * @param bucketFileSystemLocator
   */
  @Returns("directory")
  suspend fun getDirectory(@ParamName("bucketFileSystemLocator") bucketFileSystemLocator: BucketFileSystemLocator): Directory
}
